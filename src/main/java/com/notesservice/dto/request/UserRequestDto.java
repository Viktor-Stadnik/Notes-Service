package com.notesservice.dto.request;

import lombok.Data;

@Data
public class UserRequestDto {
    private String login;
    private String password;
}
