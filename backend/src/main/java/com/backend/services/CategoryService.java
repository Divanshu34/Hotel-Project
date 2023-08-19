package com.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.converters.interfaces.ICategoryConverter;
import com.backend.daos.ICategoryDAO;
import com.backend.dtos.CategoryDTO;
import com.backend.services.interfaces.ICategoryService;

@Service
@Transactional
public class CategoryService implements ICategoryService{

    private ICategoryDAO categoryDAO;
    private ICategoryConverter categoryConverter;

    
    @Autowired
    public CategoryService(ICategoryDAO categoryDAO, ICategoryConverter categoryConverter) {
        this.categoryDAO = categoryDAO;
        this.categoryConverter = categoryConverter;
    }

    @Override
    public CategoryDTO addCategory(CategoryDTO categoryDTO) {
        return categoryConverter.pojoToDto(categoryDAO.save(categoryConverter.dtoToPojo(categoryDTO)));
    }
    
}
