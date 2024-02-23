package com.example.BloggingApplication.controller;

import com.example.BloggingApplication.dto.UserDto;
import com.example.BloggingApplication.entity.User;
import com.example.BloggingApplication.exception.ResourceNotFoundException;
import com.example.BloggingApplication.mapper.UserMapper;
import com.example.BloggingApplication.mapper.loginMapper;
import com.example.BloggingApplication.service.implementation.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private loginMapper loginMapper;
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserDto userDto){
        User user = userMapper.toUser(userDto);
        User registeredUser = userService.register(user);
        return new ResponseEntity<>(HttpStatus.OK).ok(registeredUser);
    }

    // only return necessary details using userDto
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody User user){
        User loggedUser = userService.login(user);
        var dto = loginMapper.toDto(loggedUser); // convert user to dto, to expose only necessary details.
        return new ResponseEntity<>(HttpStatus.OK).ok(dto); //return id and name.
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUser(@PathVariable int userId) throws ResourceNotFoundException {
        User user = userService.findUser(userId);
        UserDto dto = userMapper.toDto(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getUsers() throws ResourceNotFoundException {
        List<User> list = userService.findUsers();
       // UserDto dto = userMapper.toDto(user);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


}
