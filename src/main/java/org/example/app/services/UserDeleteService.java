package org.example.app.services;

import org.example.app.entities.User;
import org.example.app.exceptions.UpdateException;
import org.example.app.repositories.UserDeleteRepository;
import org.example.app.utils.Constants;
import org.example.app.utils.IdValidator;

import java.util.HashMap;
import java.util.Map;

public class UserDeleteService {

    UserDeleteRepository repository;

    public UserDeleteService(UserDeleteRepository repository) {
        this.repository = repository;
    }

    public String deleteUser(String[] data) {
        Map<String, String> errors = validateData(data);
        if (!errors.isEmpty()) {
            try {
                throw new UpdateException("Check inputs", errors);
            } catch (UpdateException ue) {
                return ue.getErrors(errors);
            }
        }
        return repository.deleteUser(convertData(data));
    }

    private Map<String, String> validateData(String[] data) {
        Map<String, String> errors = new HashMap<>();
        if (IdValidator.isIdValid(data[0]))
            errors.put("id", Constants.WRONG_ID_MSG);
        return errors;
    }

    private User convertData(String[] data) {
        User user = new User();
        user.setId(Integer.parseInt(data[0]));
        return user;
    }
}
