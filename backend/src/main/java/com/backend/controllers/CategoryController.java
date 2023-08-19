package com.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dtos.CategoryDTO;
import com.backend.services.interfaces.ICategoryService;

@RestController
@RequestMapping("category")
public class CategoryController {
    private ICategoryService categoryService;

    @Autowired
    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add-category")
    public CategoryDTO addCategory(@RequestBody CategoryDTO categoryDTO){
        return categoryService.addCategory(categoryDTO);
    }
}
