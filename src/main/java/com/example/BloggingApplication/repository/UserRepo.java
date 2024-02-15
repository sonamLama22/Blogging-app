package com.example.BloggingApplication.repository;

import com.example.BloggingApplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    public User findByEmail(String email);
}
