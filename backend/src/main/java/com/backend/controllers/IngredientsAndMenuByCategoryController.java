package com.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dtos.IngredientsAndMenuByCategoryDTO;
import com.backend.pojos.enums.CategoryType;
import com.backend.services.interfaces.IIngredientsAndMenuByCategoryService;

@RequestMapping("/menu-item")
@RestController
public class IngredientsAndMenuByCategoryController {
    @Autowired
    private IIngredientsAndMenuByCategoryService ingredientsAndMenuByCategoryService;
    
    @GetMapping
    public IngredientsAndMenuByCategoryDTO getMenuItemAndIngredientsByCategory(@PathVariable CategoryType categoryName){
        return ingredientsAndMenuByCategoryService.getMenuItemAndIngredientsByCategory(categoryName);
    }
}
