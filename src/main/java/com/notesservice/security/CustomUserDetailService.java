package com.notesservice.security;

import com.notesservice.model.User;
import com.notesservice.service.UserService;
import java.util.Optional;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String login)
            throws UsernameNotFoundException {
        Optional<User> user = userService.findByLogin(login);

        UserBuilder builder;
        if (user.isPresent()) {
            builder = org.springframework.security.core.userdetails.User
                    .withUsername(login);
            builder.password(user.get().getPassword());
            builder.roles(String.valueOf(user.get().getRole().stream()
                    .map(r -> r.getRoleName().name())));
            return builder.build();
        }
        throw new UsernameNotFoundException("User with login: "
                + login + " not found");
    }
}
