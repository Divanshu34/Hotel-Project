package com.backend.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.pojos.CategoryPOJO;

public interface ICategoryDAO extends JpaRepository<CategoryPOJO, Long>{
    
}
