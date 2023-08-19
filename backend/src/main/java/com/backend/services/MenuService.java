package com.backend.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.converters.MenuConverter;
import com.backend.daos.IIngredientDAO;
import com.backend.daos.IMenuDAO;
import com.backend.dtos.MenuDTO;
import com.backend.pojos.IngredientPOJO;
import com.backend.pojos.MenuPOJO;
import com.backend.services.interfaces.IMenuService;

@Service
@Transactional
public class MenuService implements IMenuService{

    @Autowired
    private IMenuDAO menuDao;

    @Autowired
    private MenuConverter menuConverter;

    @Autowired
    private IIngredientDAO ingredientDAO;

    @Override
    public MenuDTO addItem(MenuDTO menuDTO, Set<Long> ingredientIds) {
        MenuPOJO menuPOJO = menuDao.save(menuConverter.dtoToPojo(menuDTO));
        for(IngredientPOJO ingredientPOJO : ingredientDAO.findAllById(ingredientIds)){
            menuPOJO.addIngredient(ingredientPOJO);
        }
        return menuConverter.pojoToDto(menuPOJO);
    }

}