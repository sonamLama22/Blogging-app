package com.example.BloggingApplication.mapper;

import com.example.BloggingApplication.dto.loginDto;
import com.example.BloggingApplication.entity.User;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

@Service
public class loginMapper {

    // map loginDto to user
    public User toUser(@NotNull loginDto dto){
        var user = new User();
        user.setUserId(dto.getUserId());
        user.setName(dto.getName());
        user.setAbout(dto.getAbout());
        return user;
    }

    // map user to loginDto
    public loginDto toDto(User user){
        var loginDto = new loginDto();
        loginDto.setUserId(user.getUserId());
        loginDto.setName(user.getName());
        loginDto.setAbout(user.getAbout());
        return loginDto;
    }
}
