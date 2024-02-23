package com.example.BloggingApplication.service.implementation;

import com.example.BloggingApplication.entity.Comments;
import com.example.BloggingApplication.exception.ResourceNotFoundException;
import com.example.BloggingApplication.repository.CommentRepo;
import com.example.BloggingApplication.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepo commentRepo;

    @Override
    public Comments createComment(Comments comment) {
        return commentRepo.save(comment);
    }

    @Override
    public List<Comments> getCommentsByUserId(int userId) {
        return commentRepo.findCommentsByUser_userId(userId);
    }

    @Override
    public Comments getComment(int commentId) throws ResourceNotFoundException {
        Comments c = commentRepo.findById(commentId)
                .orElseThrow(()->new ResourceNotFoundException("Comment not found for id ::"+commentId));
        return c;
    }

    @Override
    public Comments editComment(Comments comment) {
        return commentRepo.save(comment);
    }

    @Override
    public void deleteCommentById(int id) {
        commentRepo.deleteById(id);
    }

    @Override
    public List<Comments> getCommentsOfAPost(int postId) {
        return commentRepo.findCommentsByPost_postId(postId);
    }
}
