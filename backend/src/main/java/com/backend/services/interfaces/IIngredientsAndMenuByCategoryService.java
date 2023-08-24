package com.backend.services.interfaces;

import com.backend.dtos.IngredientsAndMenuByCategoryDTO;
import com.backend.pojos.enums.CategoryType;

public interface IIngredientsAndMenuByCategoryService {
    IngredientsAndMenuByCategoryDTO getMenuItemAndIngredientsByCategory(CategoryType categoryName);
}
