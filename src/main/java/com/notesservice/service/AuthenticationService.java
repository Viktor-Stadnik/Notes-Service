package com.notesservice.service;

import com.notesservice.model.User;

public interface AuthenticationService {
    User registration(String login, String password);
}
