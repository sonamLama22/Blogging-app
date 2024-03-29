package com.example.BloggingApplication.repository;

import com.example.BloggingApplication.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {

    public List<Post> findPostsByUser_userId(int userId);
    public List<Post> findPostsByCategory_categoryId(int categoryId);

}
