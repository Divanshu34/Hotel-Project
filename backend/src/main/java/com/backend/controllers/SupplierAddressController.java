package com.backend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dtos.SupplierAddressDTO;
import com.backend.services.interfaces.ISupplierAddressService;

@RestController
@RequestMapping("supplier-address")
public class SupplierAddressController {
    private ISupplierAddressService supplierAddressService;

    @PostMapping("/{supplerId}")
    public ResponseEntity<?> addSupplierAddress(@RequestBody SupplierAddressDTO supplierAddressDTO, @PathVariable Long supplierId) {
        return ResponseEntity.status(HttpStatus.OK).body(supplierAddressService.addSupplierAddress(supplierAddressDTO, supplierId));
    }
    
}
