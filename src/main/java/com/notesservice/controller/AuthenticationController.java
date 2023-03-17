package com.notesservice.controller;

import com.notesservice.dto.mapper.UserMapper;
import com.notesservice.dto.request.UserRequestDto;
import com.notesservice.dto.response.UserResponseDto;
import com.notesservice.model.User;
import com.notesservice.service.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserMapper mapper;

    public AuthenticationController(AuthenticationService authenticationService,
                                    UserMapper mapper) {
        this.authenticationService = authenticationService;
        this.mapper = mapper;
    }

    @PostMapping()
    public UserResponseDto registration(@RequestBody UserRequestDto requestDto) {
        User user = authenticationService.registration(requestDto.getLogin(),
                requestDto.getPassword());
        return mapper.toResponseDto(user);
    }
}
