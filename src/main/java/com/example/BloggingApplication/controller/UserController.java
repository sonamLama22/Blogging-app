package com.example.BloggingApplication.controller;

import com.example.BloggingApplication.dto.UserDto;
import com.example.BloggingApplication.entity.User;
import com.example.BloggingApplication.mapper.loginMapper;
import com.example.BloggingApplication.service.implementation.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private loginMapper userMapper;
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserDto user){
        User registeredUser = userService.register(user);
        return new ResponseEntity<>(HttpStatus.OK).ok(registeredUser);
    }

 //   @PostMapping("/login")
//    public ResponseEntity<?> loginUser(@RequestBody User u){
//        User loggedUser = userService.login(u);
//        return new ResponseEntity<>(HttpStatus.OK).ok(loggedUser); //returns entire user object.
//    }

    // only return necessary details using userDto
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody User user){
        User loggedUser = userService.login(user);
        var dto = userMapper.toDto(loggedUser); // convert user to dto, to expose only necessary details.
        return new ResponseEntity<>(HttpStatus.OK).ok(dto); //return name and about.
    }
}
