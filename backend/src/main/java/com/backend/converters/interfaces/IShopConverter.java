package com.backend.converters.interfaces;

import java.util.List;

import com.backend.dtos.ShopDTO;
import com.backend.pojos.ShopPOJO;

public interface IShopConverter {
    public ShopPOJO dtoToPojo(ShopDTO shopDTO);

    public List<ShopPOJO> dtoToPojo(List<ShopDTO> shopDTOs);

    public ShopDTO pojoToDto(ShopPOJO shopPOJO);

    public List<ShopDTO> pojoToDto(List<ShopPOJO> shopPOJOs);
}
