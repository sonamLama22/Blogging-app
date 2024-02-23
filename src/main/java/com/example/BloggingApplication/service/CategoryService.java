package com.example.BloggingApplication.service;

import com.example.BloggingApplication.entity.Category;
import com.example.BloggingApplication.entity.Post;
import com.example.BloggingApplication.exception.ResourceNotFoundException;

import java.util.List;

public interface CategoryService {

    public Category createCategory(Category category);
    public Category getCategory(int categoryId) throws ResourceNotFoundException;
    public List<Category> getListOfCategories();
}
