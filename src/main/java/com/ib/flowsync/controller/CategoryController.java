package com.ib.flowsync.controller;

import com.ib.flowsync.entity.Category;
import com.ib.flowsync.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    
    @Autowired
    CategoryService categoryService;

    @PostMapping("")
    public ResponseEntity<String> createCategory(
            @RequestBody Category category
    ) {
        categoryService.createCategory(category);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Category creation was successful");
    }

    @GetMapping("")
    public List<Category> getAllCategory() {
        return categoryService.getAllCategory();
    }

    @GetMapping("/{categoryId}")
    public @ResponseBody Category getCategoryById(
            @PathVariable(value = "categoryId") Integer categoryId
    ) throws ResponseStatusException {
        Category category = categoryService.getCategoryById(categoryId);

        if(category == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "category not found");

        return category;
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<String> updateCategory(
            @PathVariable(value = "categoryId") Integer categoryId,
            @RequestBody Category category
    ) {
        categoryService.updateCategory(category, categoryId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Category update was successful");
    }

    @DeleteMapping("/{categoryId}")
    public @ResponseBody void deleteCategory(
            @PathVariable(value = "categoryId") Integer categoryId
    ) {
        categoryService.deleteCategory(categoryId);
    }
}
