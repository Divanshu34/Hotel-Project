package com.backend.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.converters.MenuConverter;
import com.backend.daos.IMenuDAO;
import com.backend.dtos.MenuDTO;
import com.backend.pojos.MenuPOJO;
import com.backend.services.interfaces.IMenuService;

@Service
@Transactional
public class MenuService{

    @Autowired
    private IMenuDAO menuDao;

    @Autowired
    private MenuConverter menuConverter;

    @Override
    public MenuDTO addMenu(MenuDTO menuDTO) {
        menuDao.save(menuConverter.dtoToPojo(menuDTO));
    }

//     @Override
//     public List<MenuDTO> allMenu() {
//         return menuConverter.pojoToDto(menuDao.findAll());
//     }
}