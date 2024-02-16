package com.example.BloggingApplication.entity;

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

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email should not be empty")
    @JsonProperty("email")
    private String email;

    @NotEmpty(message = "Password cannot be empty")
    @Size(min=8, message = "Password must be at least 8 characters")
    @JsonProperty("password")
    private String password;
    private String about;
}
