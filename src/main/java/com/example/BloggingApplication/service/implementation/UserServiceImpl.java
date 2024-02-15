package com.example.BloggingApplication.service.implementation;

import com.example.BloggingApplication.dto.UserDto;
import com.example.BloggingApplication.dto.loginDto;
import com.example.BloggingApplication.entity.Post;
import com.example.BloggingApplication.entity.User;
import com.example.BloggingApplication.repository.UserRepo;
import com.example.BloggingApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepo userRepo;

    @Override
    public User register(UserDto user) {
        User u = new User();
        u.setName(user.getName());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        u.setAbout(user.getAbout());
        return userRepo.save(u);
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
