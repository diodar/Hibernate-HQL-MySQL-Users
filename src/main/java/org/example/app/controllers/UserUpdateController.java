package org.example.app.controllers;

import org.example.app.services.UserUpdateService;
import org.example.app.utils.AppStarter;
import org.example.app.views.UserUpdateView;

public class UserUpdateController {

    UserUpdateService service;
    UserUpdateView view;

    public UserUpdateController(UserUpdateService service, UserUpdateView view) {
        this.service = service;
        this.view = view;
    }

    public void updateUser() {
        view.getOutput(service.updateUser(view.getData()));
        AppStarter.startApp();
    }
}
