package com.example.BloggingApplication.service.implementation;

import com.example.BloggingApplication.entity.Category;
import com.example.BloggingApplication.entity.Post;
import com.example.BloggingApplication.exception.ResourceNotFoundException;
import com.example.BloggingApplication.repository.CategoryRepo;
import com.example.BloggingApplication.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Category createCategory(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public Category getCategory(int categoryId) throws ResourceNotFoundException {
        Category c = categoryRepo.findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("Category not found for this id::"+categoryId));
        return c;
    }

    @Override
    public List<Category> getListOfCategories() {
        return categoryRepo.findAll();
    }

}
