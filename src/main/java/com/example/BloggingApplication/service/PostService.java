package com.example.BloggingApplication.service;

import com.example.BloggingApplication.dto.PostDto;
import com.example.BloggingApplication.entity.Post;
import com.example.BloggingApplication.exception.ResourceNotFoundException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface PostService {

    public Post createPost(Post post, MultipartFile file) throws Exception;
    public PostDto getPost(int postId) throws ResourceNotFoundException;
    public Post updatePost(Post post);
    public String deletePost(int postId) throws ResourceNotFoundException;
    public List<Post> findPostsByUserId(int userId);
    public List<Post> finPostsByCategoryId(int categoryId);
//    public Post saveImage(MultipartFile file) throws Exception;
}
