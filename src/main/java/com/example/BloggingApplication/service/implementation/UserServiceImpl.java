package com.example.BloggingApplication.service.implementation;

import com.example.BloggingApplication.dto.UserDto;
import com.example.BloggingApplication.entity.Post;
import com.example.BloggingApplication.entity.User;
import com.example.BloggingApplication.exception.ResourceNotFoundException;
import com.example.BloggingApplication.mapper.UserMapper;
import com.example.BloggingApplication.mapper.loginMapper;
import com.example.BloggingApplication.repository.UserRepo;
import com.example.BloggingApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepo userRepo;
    @Autowired
    public UserMapper userMapper;

    @Override
    public User register(User user) {
//        User registeredUser = userMapper.toUser(dto); // map dto to user
        return userRepo.save(user);
    }

    @Override
    public User login(User user) {
        return userRepo.findByEmail(user.getEmail());
    }

    @Override
    public void userExists(int id) throws ResourceNotFoundException {
        userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found for this id ::"+id));
    }

    @Override
    public User findUser(int userId) throws ResourceNotFoundException {
        return userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User not found for this id ::"+userId));
    }

    @Override
    public List<User> findUsers() {
        return userRepo.findAll();
    }
}
