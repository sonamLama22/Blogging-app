package com.example.BloggingApplication.service;

import com.example.BloggingApplication.dto.UserDto;
import com.example.BloggingApplication.dto.loginDto;
import com.example.BloggingApplication.entity.Post;
import com.example.BloggingApplication.entity.User;
import com.example.BloggingApplication.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    public User register(User user);
    public User login(User user);
    public void userExists(int userId) throws ResourceNotFoundException;
    public User findUser(int userId) throws ResourceNotFoundException;
    public List<User> findUsers();
}
