package com.backend.converters;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.converters.interfaces.ISupplierAddressConverter;
import com.backend.dtos.SupplierAddressDTO;
import com.backend.pojos.SupplierAddressPOJO;

@Component
public class SupplierAddressConverter implements ISupplierAddressConverter{

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SupplierAddressPOJO dtoToPojo(SupplierAddressDTO supplierAddressDTO) {
        return modelMapper.map(supplierAddressDTO, SupplierAddressPOJO.class); 
    }

    @Override
    public List<SupplierAddressPOJO> dtoToPojo(List<SupplierAddressDTO> supplierAddressDTOs) {
        return supplierAddressDTOs.stream().map(x -> dtoToPojo(x)).collect(Collectors.toList());
    }

    @Override
    public SupplierAddressDTO pojoToDto(SupplierAddressPOJO supplierAddressPOJO) {
        return modelMapper.map(supplierAddressPOJO, SupplierAddressDTO.class);
    }

    @Override
    public List<SupplierAddressDTO> pojoToDto(List<SupplierAddressPOJO> supplierAddressPOJOs) {
        return supplierAddressPOJOs.stream().map(x -> pojoToDto(x)).collect(Collectors.toList());
    }
    
}
