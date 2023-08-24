package com.backend.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.pojos.CategoryPOJO;
import com.backend.pojos.MenuPOJO;
import java.util.List;


public interface IMenuDAO extends JpaRepository<MenuPOJO, Long> {
    MenuPOJO findByCategory(CategoryPOJO category);
}