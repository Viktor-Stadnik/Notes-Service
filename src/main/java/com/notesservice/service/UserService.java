package com.notesservice.service;

import com.notesservice.model.User;
import java.util.Optional;

public interface UserService {
    Optional<User> findByLogin(String login);

    User add(User user);
}
