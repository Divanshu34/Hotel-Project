package com.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.converters.interfaces.IMenuPojoToMenuAndIngredientConverter;
import com.backend.daos.ICategoryDAO;
import com.backend.daos.IMenuDAO;
import com.backend.dtos.IngredientsAndMenuByCategoryDTO;
import com.backend.pojos.MenuPOJO;
import com.backend.pojos.enums.CategoryType;
import com.backend.services.interfaces.IIngredientsAndMenuByCategoryService;

@Service
@Transactional
public class IngredientsAndMenuByCategoryService implements IIngredientsAndMenuByCategoryService {

    @Autowired
    private IMenuDAO menuDAO;
    @Autowired
    private ICategoryDAO categoryDAO;
    @Autowired
    private IMenuPojoToMenuAndIngredientConverter menuAndIngredientConverter;

    @Override
    public IngredientsAndMenuByCategoryDTO getMenuItemAndIngredientsByCategory(CategoryType categoryName) {
        MenuPOJO menuPOJO = menuDAO.findByCategory(categoryDAO.findByCategoryName(categoryName));
        return menuAndIngredientConverter.pojoToDto(menuPOJO, categoryName);
    }

}
