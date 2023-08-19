package com.backend.services.interfaces;

import com.backend.dtos.AddressDTO;

public interface IAddressService {
    
    AddressDTO addAddress(AddressDTO address, Long userId);

}
