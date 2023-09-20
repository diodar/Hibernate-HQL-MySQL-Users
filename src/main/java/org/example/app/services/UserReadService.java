package org.example.app.services;

import org.example.app.entities.User;
import org.example.app.repositories.UserReadRepository;
import org.example.app.utils.Constants;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class UserReadService {

    UserReadRepository repository;

    public UserReadService(UserReadRepository repository) {
        this.repository = repository;
    }

    public String readUsers() {

        List<User> list = repository.readUsers();

        if (list != null) {

            if (!list.isEmpty()) {
                AtomicInteger count = new AtomicInteger(0);
                StringBuilder stringBuilder = new StringBuilder();
                list.forEach((contact) ->
                        stringBuilder.append(count.incrementAndGet())
                                .append(") id: ")
                                .append(contact.getId())
                                .append(", ")
                                .append(contact.getUserName())
                                .append(", ")
                                .append(contact.getFirstName())
                                .append(" ")
                                .append(contact.getLastName())
                                .append(", ")
                                .append(contact.getEmail())
                                .append("\n")
                );
                return "\n______ CONTACTS ___________\n" + stringBuilder;
            } else return Constants.DATA_ABSENT_MSG;
        } else return Constants.DATA_ABSENT_MSG;
    }
}
