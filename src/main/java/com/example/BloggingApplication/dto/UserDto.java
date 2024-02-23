package com.example.BloggingApplication.dto;

import com.example.BloggingApplication.entity.Post;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

   private int userId;

   @NotEmpty(message = "name cannot be empty")
   @Size(min=3, message = "Name should have at least 3 characters")
   @JsonProperty("name")
   private String name;

   @Email(message = "Email should be valid")
   @NotBlank(message = "Email should not be empty")
   @JsonProperty("email")
   private String email;

//   private List<Post> postList;
//
   @NotEmpty(message = "Password cannot be empty")
   @Size(min=8, message = "Password must be at least 8 characters")
   @JsonProperty("password")
   private String password;
//
   //@NotEmpty(message = "about cannot be empty")
   @JsonProperty("about")
   private String about;

}
