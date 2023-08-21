package com.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.converters.interfaces.ISupplierAddressConverter;
import com.backend.daos.ISupplierAddressDAO;
import com.backend.daos.ISupplierDAO;
import com.backend.dtos.SupplierAddressDTO;
import com.backend.pojos.SupplierAddressPOJO;
import com.backend.pojos.SupplierPOJO;
import com.backend.services.interfaces.ISupplierAddressService;

@Service
@Transactional
public class SupplierAddressService implements ISupplierAddressService {

    private ISupplierAddressDAO supplierAddressDAO;
    private ISupplierDAO supplierDAO;
    private ISupplierAddressConverter supplierAddressConverter;

    @Autowired
    public SupplierAddressService(ISupplierAddressDAO supplierAddressDAO, ISupplierDAO supplierDAO,
            ISupplierAddressConverter supplierAddressConverter) {
        this.supplierAddressDAO = supplierAddressDAO;
        this.supplierDAO = supplierDAO;
        this.supplierAddressConverter = supplierAddressConverter;
    }

    @Override
    public SupplierAddressDTO addSupplierAddress(SupplierAddressDTO supplierAddressDTO, Long supplierId) {
        SupplierPOJO supplierPOJO = supplierDAO.findById(supplierId).get();
        SupplierAddressPOJO supplierAddressPOJO = supplierAddressDAO
                .save(supplierAddressConverter.dtoToPojo(supplierAddressDTO));
        supplierPOJO.addSupplierAddress(supplierAddressPOJO);
        return supplierAddressConverter.pojoToDto(supplierAddressPOJO);

    }

}
