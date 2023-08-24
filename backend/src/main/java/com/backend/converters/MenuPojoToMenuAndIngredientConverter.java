package com.backend.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.backend.converters.interfaces.IMenuPojoToMenuAndIngredientConverter;
import com.backend.pojos.IngredientPOJO;
import com.backend.dtos.IngredientsAndMenuByCategoryDTO;
import com.backend.pojos.MenuPOJO;
import com.backend.pojos.enums.CategoryType;

@Component
public class MenuPojoToMenuAndIngredientConverter implements IMenuPojoToMenuAndIngredientConverter{

    // @Override
    // public MenuPOJO dtoToPojo(IngredientsAndMenuByCategoryDTO ingredientsAndMenuByCategoryDTO) {
    //     MenuPOJO menuPOJO = new MenuPOJO();
        
    // }

    // @Override
    // public List<MenuPOJO> dtoToPojo(List<IngredientsAndMenuByCategoryDTO> ingredientsAndMenuByCategoryDTOs) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'dtoToPojo'");
    // }

    @Override
    public IngredientsAndMenuByCategoryDTO pojoToDto(MenuPOJO menuPOJO, CategoryType categoryName) {
        IngredientsAndMenuByCategoryDTO ingredientsAndMenuByCategoryDTO = new IngredientsAndMenuByCategoryDTO();

        ingredientsAndMenuByCategoryDTO.setIngredientNames(menuPOJO.getIngredients().stream().map(IngredientPOJO::getIngredient).collect(Collectors.toSet()));
        ingredientsAndMenuByCategoryDTO.setCategoryType(categoryName);
        ingredientsAndMenuByCategoryDTO.setItemName(menuPOJO.getItemName());
        ingredientsAndMenuByCategoryDTO.setItemName(menuPOJO.getItemName());
        return ingredientsAndMenuByCategoryDTO;
    }

    // @Override
    // public List<IngredientsAndMenuByCategoryDTO> pojoToDto(List<MenuPOJO> menuPOJOs) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'pojoToDto'");
    // }
    
}
