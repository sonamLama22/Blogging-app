package com.example.BloggingApplication.repository;

import com.example.BloggingApplication.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comments, Integer> {

    public List<Comments> findCommentsByUser_userId(int userId);
    public List<Comments> findCommentsByPost_postId(int postId);
}
