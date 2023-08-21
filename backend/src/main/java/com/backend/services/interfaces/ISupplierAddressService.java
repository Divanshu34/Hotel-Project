package com.backend.services.interfaces;

import com.backend.dtos.SupplierAddressDTO;

public interface ISupplierAddressService {
    SupplierAddressDTO addSupplierAddress(SupplierAddressDTO supplierAddressDTO, Long supplierId);
}
