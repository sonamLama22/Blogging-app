package com.example.BloggingApplication.mapper;

import com.example.BloggingApplication.dto.UserDto;
import com.example.BloggingApplication.dto.loginDto;
import com.example.BloggingApplication.entity.User;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    // map userDto to user
    public User toUser(@NotNull UserDto dto){
        var user = new User();
        user.setUserId(dto.getUserId());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setAbout(dto.getAbout());
        return user;
    }

    // map user to userDto
    public UserDto toDto(User user){
        var userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setAbout(user.getAbout());
        return userDto;
    }
}
