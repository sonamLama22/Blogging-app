package com.example.BloggingApplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    private String name;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email should not be empty")
    @JsonProperty("email")
    private String email;

    @NotEmpty(message = "Password cannot be empty")
    @Size(min=8, message = "Password must be at least 8 characters")
    @JsonProperty("password")
    //@JsonIgnore
    private String password;

    //@NotEmpty(message = "about cannot be empty")
    @JsonProperty("about")
    private String about;

//    // One user can have multiple posts.
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) //map on the basis of "user", and ignore the table created by this relationship.
//    private List<Post> postList = new ArrayList<>(); // new table is created for this field.
//
}
