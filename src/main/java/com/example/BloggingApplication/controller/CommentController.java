package com.example.BloggingApplication.controller;

import com.example.BloggingApplication.dto.PostDto;
import com.example.BloggingApplication.entity.Comments;
import com.example.BloggingApplication.entity.Post;
import com.example.BloggingApplication.exception.ResourceNotFoundException;
import com.example.BloggingApplication.service.CommentService;
import com.example.BloggingApplication.service.implementation.CommentServiceImpl;
import com.example.BloggingApplication.service.implementation.PostServiceImpl;
import com.example.BloggingApplication.service.implementation.UserServiceImpl;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentServiceImpl commentService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private PostServiceImpl postService;

    @PostMapping("/create-comment")
    public ResponseEntity<?> createComment(@RequestBody Comments comment){
        Comments savedComment = commentService.createComment(comment);
        return new ResponseEntity<>(savedComment, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getCommentsOfUserId(@PathVariable int userId) throws ResourceNotFoundException {
        userService.userExists(userId); // check if user exists
        List<Comments> list = commentService.getCommentsByUserId(userId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<?> getCommentsOfAPost(@PathVariable int postId) throws ResourceNotFoundException {
       PostDto post = postService.getPost(postId);
       if(post != null){
           List<Comments> list = commentService.getCommentsOfAPost(postId);
           return new ResponseEntity<>(list, HttpStatus.OK);
       }
       return new ResponseEntity<>("Could not get comments of this post.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/edit/{commentId}")
    public ResponseEntity<?> editComment(@RequestBody Comments comment, @PathVariable int commentId) throws ResourceNotFoundException {
        Comments c = commentService.getComment(commentId); // check if comment exists.
        if( c != null){
            Comments editedComment = commentService.editComment(comment);
            return new ResponseEntity<>(editedComment, HttpStatus.OK);
        }
        return new ResponseEntity<>("Comment could not be updated", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable int commentId) throws ResourceNotFoundException {
        Comments c = commentService.getComment(commentId);
        if( c != null){
            commentService.deleteCommentById(commentId);
            return new ResponseEntity<>("Comment has been deleted successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Comment could not be deleted.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
