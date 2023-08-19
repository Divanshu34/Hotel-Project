package com.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.converters.interfaces.ISupplierConverter;
import com.backend.daos.IShopDAO;
import com.backend.daos.ISupplierDAO;
import com.backend.dtos.SupplierDTO;
import com.backend.pojos.ShopPOJO;
import com.backend.pojos.SupplierPOJO;
import com.backend.services.interfaces.ISupplierService;

@Service
@Transactional
public class SupplierService implements ISupplierService {

    private ISupplierDAO supplierDAO;
    private ISupplierConverter supplierConverter;
    private IShopDAO shopDAO;

    @Autowired
    public SupplierService(ISupplierDAO supplierDAO, ISupplierConverter supplierConverter, IShopDAO shopDAO) {
        this.supplierDAO = supplierDAO;
        this.supplierConverter = supplierConverter;
        this.shopDAO = shopDAO;
    }

    @Override
    public SupplierDTO addSupplier(SupplierDTO supplierDTO, Long shopId) {
        ShopPOJO shopPOJO = shopDAO.findById(shopId).get();
        SupplierPOJO supplierPOJO = supplierConverter.dtoToPojo(supplierDTO);
        shopPOJO.addSupplier(supplierPOJO);
        return supplierConverter.pojoToDto(supplierDAO.save(supplierPOJO));
    }

}
