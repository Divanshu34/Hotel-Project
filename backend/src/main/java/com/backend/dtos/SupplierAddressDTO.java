package com.backend.dtos;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@NoArgsConstructor
public class SupplierAddressDTO {
    private String addressLine;
    private String city;
    private String pincode;
    private String state;

}
