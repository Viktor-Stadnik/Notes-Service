package com.notesservice.service.impl;

import com.notesservice.model.Role;
import com.notesservice.model.User;
import com.notesservice.service.AuthenticationService;
import com.notesservice.service.RoleService;
import com.notesservice.service.UserService;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final RoleService roleService;

    public AuthenticationServiceImpl(UserService userService,
                                     RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public User registration(String login, String password) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        Role userRole = new Role(Role.RoleName.USER);
        roleService.add(userRole);
        user.setRole(Set.of(userRole));
        userService.add(user);
        return user;
    }
}
