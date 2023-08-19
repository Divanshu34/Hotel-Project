package com.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.converters.interfaces.IShopConverter;
import com.backend.daos.IShopDAO;
import com.backend.dtos.ShopDTO;
import com.backend.services.interfaces.IShopService;

@Service
@Transactional
public class ShopService implements IShopService {

    private IShopDAO shopDAO;
    private IShopConverter shopConverter;

    @Autowired
    public ShopService(IShopDAO shopDAO, IShopConverter shopConverter) {
        this.shopDAO = shopDAO;
        this.shopConverter = shopConverter;
    }

    @Override
    public ShopDTO addShop(ShopDTO shopDTO) {
        return shopConverter.pojoToDto(shopDAO.save(shopConverter.dtoToPojo(shopDTO)));
    }

}
