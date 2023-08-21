package com.backend.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.pojos.SupplierAddressPOJO;

public interface ISupplierAddressDAO extends JpaRepository<SupplierAddressPOJO, Long>{
    
}
