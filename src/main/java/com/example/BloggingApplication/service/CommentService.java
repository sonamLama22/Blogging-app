package com.example.BloggingApplication.service;

import com.example.BloggingApplication.entity.Comments;
import com.example.BloggingApplication.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    public Comments createComment(Comments comments);
    public List<Comments> getCommentsByUserId(int userId);
    public Comments getComment(int commentId) throws ResourceNotFoundException;
    public Comments editComment(Comments comment);
    public void deleteCommentById(int id);
    public List<Comments> getCommentsOfAPost(int postId);
}
