package com.example.BloggingApplication.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

   @NotNull
   @Size(min=3, message = "Name should have at least 3 characters")
   @JsonProperty("name")
   private String name;

   @Email
   @NotBlank
   @JsonProperty("email")
   private String email;

   @NotEmpty
   @Size(min=8, message = "Password must be at least 8 characters")
   @JsonProperty("password")
   private String password;

   @NotEmpty
   @JsonProperty("about")
   private String about;

}
