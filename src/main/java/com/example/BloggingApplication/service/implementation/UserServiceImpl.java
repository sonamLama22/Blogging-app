package com.example.BloggingApplication.service.implementation;

import com.example.BloggingApplication.dto.UserDto;
import com.example.BloggingApplication.entity.Post;
import com.example.BloggingApplication.entity.User;
import com.example.BloggingApplication.mapper.UserMapper;
import com.example.BloggingApplication.mapper.loginMapper;
import com.example.BloggingApplication.repository.UserRepo;
import com.example.BloggingApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepo userRepo;
    @Autowired
    public UserMapper userMapper;

    @Override
    public User register(UserDto dto) {
        User registeredUser = userMapper.toUser(dto); // map dto to user
        return userRepo.save(registeredUser);
    }

    @Override
    public User login(User user) {
        return userRepo.findByEmail(user.getEmail());
    }

    @Override
    public String createPost(Post post) {
        return null;
    }

    @Override
    public Post getPost(int postId) {
        return null;
    }

    @Override
    public Post updatePost(Post post) {
        return null;
    }

    @Override
    public boolean deletePost(int postId) {
        return false;
    }

    @Override
    public List<Post> listAll() {
        return null;
    }
}
