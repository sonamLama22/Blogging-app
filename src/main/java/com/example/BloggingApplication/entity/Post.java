package com.example.BloggingApplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;
    private String title;
    private String content;

    // adds foreign key in Post table that corresponds to user_id in users table.
    @ManyToOne
    @JoinColumn(name = "user_id")
    //@JsonIgnore // ignore the user field from response
    private User user;

    @ManyToOne
    @JoinColumn(name="categoryId")
    private Category category;

    private String fileName;
    private String fileType;

    @Lob
    private byte[] data;

}
