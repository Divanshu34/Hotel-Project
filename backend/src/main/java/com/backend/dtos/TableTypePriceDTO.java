package com.backend.dtos;

import org.springframework.stereotype.Component;

import com.backend.pojos.enums.TableType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Component
public class TableTypePriceDTO {
    private Long tableTypeId;
    private TableType tableType;
    private Double price;
    private byte[] tableImage;
    private Long seats;
    private Long availableTables;

    
}
