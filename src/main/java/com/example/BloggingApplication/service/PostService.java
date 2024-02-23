package com.example.BloggingApplication.service;

import com.example.BloggingApplication.dto.PostDto;
import com.example.BloggingApplication.entity.Post;
import com.example.BloggingApplication.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Map;

public interface PostService {

    public Post createPost(Post post);
    public PostDto getPost(int postId) throws ResourceNotFoundException;
    public Post updatePost(Post post);
    public String deletePost(int postId) throws ResourceNotFoundException;
//    public List<Post>  listAllPosts() ;
    public List<Post> findPostsByUserId(int userId);
    public List<Post> finPostsByCategoryId(int categoryId);
}
