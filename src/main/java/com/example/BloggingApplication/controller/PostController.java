package com.example.BloggingApplication.controller;

import com.example.BloggingApplication.dto.PostDto;
import com.example.BloggingApplication.entity.Category;
import com.example.BloggingApplication.entity.Comments;
import com.example.BloggingApplication.entity.Post;
import com.example.BloggingApplication.entity.User;
import com.example.BloggingApplication.exception.ResourceNotFoundException;
import com.example.BloggingApplication.service.CategoryService;
import com.example.BloggingApplication.service.implementation.CategoryServiceImpl;
import com.example.BloggingApplication.service.implementation.PostServiceImpl;
import com.example.BloggingApplication.service.implementation.UserServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/blog")
public class PostController {
    @Autowired
    PostServiceImpl postService;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    CategoryServiceImpl categoryService;

    @PostMapping("/userId={userId}/categoryId={categoryId}/create-post")
    public ResponseEntity<?> createPost(@PathVariable int userId, @RequestBody PostDto postDto, @PathVariable int categoryId) throws ResourceNotFoundException {
        userService.userExists(userId); //check if user exists.
        categoryService.getCategory(categoryId); //check if category exists.
        Post post = new Post();
        BeanUtils.copyProperties(postDto, post);
        Post postCreated = postService.createPost(post);
        return new ResponseEntity<>(postCreated, HttpStatus.OK);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<?> getPost(@PathVariable int postId) throws ResourceNotFoundException {
        PostDto post = postService.getPost(postId);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @GetMapping("/userId={userId}/posts")
    public ResponseEntity<?> getAllPostsOfUser(@PathVariable int userId) throws ResourceNotFoundException {
        userService.userExists(userId);
        List<Post>  list = postService.findPostsByUserId(userId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PutMapping("/update/{postId}")
    public ResponseEntity<?> updatePost(@RequestBody PostDto postDto, @PathVariable int postId) throws ResourceNotFoundException {
        PostDto p = postService.getPost(postId);
        if(p != null){
            Post post = new Post();
            BeanUtils.copyProperties(postDto, post);
            Post updatedPost = postService.updatePost(post);
            return new ResponseEntity<>(updatedPost, HttpStatus.OK);
        }
        return new ResponseEntity<>("Post could not be updated.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable int postId) throws ResourceNotFoundException {
        PostDto p = postService.getPost(postId);
        if( p != null){
            postService.deletePost(postId);
            return new ResponseEntity<>("Post has been deleted successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Post could not be deleted.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/categoryId={categoryId}/posts")
    public ResponseEntity<?> ListPostsByCategory(@PathVariable int categoryId) throws ResourceNotFoundException {
        Category category = categoryService.getCategory(categoryId);
        List<Post> list = postService.finPostsByCategoryId(categoryId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
