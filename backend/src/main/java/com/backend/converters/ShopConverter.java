package com.backend.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.backend.converters.interfaces.IShopConverter;
import com.backend.dtos.ShopDTO;
import com.backend.pojos.ShopPOJO;

public class ShopConverter implements IShopConverter {

    private ModelMapper modelMapper;

    @Autowired
    public ShopConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ShopPOJO dtoToPojo(ShopDTO shopDTO) {
        return modelMapper.map(shopDTO, ShopPOJO.class);
    }

    @Override
    public List<ShopPOJO> dtoToPojo(List<ShopDTO> shopDTOs) {
        return shopDTOs.stream().map(x -> dtoToPojo(x)).collect(Collectors.toList());
    }

    @Override
    public ShopDTO pojoToDto(ShopPOJO shopPOJO) {
        return modelMapper.map(shopPOJO, ShopDTO.class);
    }

    @Override
    public List<ShopDTO> pojoToDto(List<ShopPOJO> shopPOJOs) {
        return shopPOJOs.stream().map(x -> pojoToDto(x)).collect(Collectors.toList());
    }

}
