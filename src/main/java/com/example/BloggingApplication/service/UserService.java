package com.example.BloggingApplication.service;

import com.example.BloggingApplication.dto.UserDto;
import com.example.BloggingApplication.dto.loginDto;
import com.example.BloggingApplication.entity.Post;
import com.example.BloggingApplication.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    public User register(UserDto user);
    public User login(User user);
    public String createPost(Post post);
    public Post getPost(int postId);
    public Post updatePost(Post post);
    public boolean deletePost(int postId);
    public List<Post> listAll();
}
