package com.backend.converters.interfaces;

import java.util.List;

import com.backend.dtos.SupplierAddressDTO;
import com.backend.pojos.SupplierAddressPOJO;

public interface ISupplierAddressConverter {
    public SupplierAddressPOJO dtoToPojo(SupplierAddressDTO supplierAddressDTO);

    public List<SupplierAddressPOJO> dtoToPojo(List<SupplierAddressDTO> supplierAddressDTOs);

    public SupplierAddressDTO pojoToDto(SupplierAddressPOJO supplierAddressPOJO);

    public List<SupplierAddressDTO> pojoToDto(List<SupplierAddressPOJO> supplierAddressPOJOs);
}
