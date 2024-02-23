package com.example.BloggingApplication.controller;

import com.example.BloggingApplication.entity.Category;
import com.example.BloggingApplication.service.implementation.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryService;

    @PostMapping("/create-category")
    public ResponseEntity<?> createCategory(@RequestBody Category category){
        Category savedCategory = categoryService.createCategory(category);
        return new ResponseEntity<>(savedCategory, HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<?> getCategoryList(){
        List<Category> list = categoryService.getListOfCategories();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
