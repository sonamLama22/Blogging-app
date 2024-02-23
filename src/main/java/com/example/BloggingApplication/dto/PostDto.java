package com.example.BloggingApplication.dto;


import com.example.BloggingApplication.entity.Category;
import com.example.BloggingApplication.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private int postId;
    private String title;
    private String content;
    private User user;
    private Category category;
}
