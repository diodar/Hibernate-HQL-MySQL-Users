package org.example.app.services;

import org.example.app.entities.User;
import org.example.app.exceptions.CreateException;
import org.example.app.repositories.UserCreateRepository;
import org.example.app.utils.Constants;
import org.example.app.utils.EmailValidator;

import java.util.HashMap;
import java.util.Map;

public class UserCreateService {

    UserCreateRepository repository;

    public UserCreateService(UserCreateRepository repository) {
        this.repository = repository;
    }

    public String createUser(String[] data) {
        Map<String, String> errors = validateData(data);
        if (!errors.isEmpty()) {
            try {
                throw new CreateException("Check inputs", errors);
            } catch (CreateException ce) {
                return ce.getErrors(errors);
            }
        }
        return repository.createUser(convertData(data));
    }

    private Map<String, String> validateData(String[] data) {
        Map<String, String> errors = new HashMap<>();
        if (data[0].isEmpty())
            errors.put("user name", Constants.INPUT_REQ_MSG);
        if (data[1].isEmpty())
            errors.put("first name", Constants.INPUT_REQ_MSG);
        if (data[2].isEmpty())
            errors.put("last name", Constants.INPUT_REQ_MSG);
        if (EmailValidator.isEmailValid(data[3]))
            errors.put("email", Constants.WRONG_EMAIL_MSG);
        return errors;
    }

    private User convertData(String[] data) {
        User user = new User();
        user.setUserName(data[0]);
        user.setFirstName(data[1]);
        user.setLastName(data[2]);
        user.setEmail(data[3]);
        return user;
    }
}
