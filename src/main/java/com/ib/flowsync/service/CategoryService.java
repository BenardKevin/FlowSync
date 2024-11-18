package com.ib.flowsync.service;

import com.ib.flowsync.entity.Category;
import com.ib.flowsync.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void createCategory(Category category) {
        category.setId(null);
        categoryRepository.save(category);
    }

    public List<Category> getAllCategory() {
        return (List<Category>) categoryRepository.findAll();
    }

    public Category getCategoryById(Integer categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }

    public Category getCategoryByName(String name) {
        return categoryRepository.findByName(name).orElse(null);
    }

    public void updateCategory(Category category, Integer categoryId) {
        category.setId(categoryId);
        categoryRepository.save(category);
    }

    public void deleteCategory(Integer categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
