package com.notesservice.dto.mapper;

import com.notesservice.dto.response.UserResponseDto;
import com.notesservice.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponseDto toResponseDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setLogin(user.getLogin());
        return responseDto;
    }
}
