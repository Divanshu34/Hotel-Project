package com.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dtos.ConfirmTableReservationDetails;
import com.backend.dtos.TableReservationDTO;
import com.backend.services.interfaces.ITableReservationService;

@RestController
@RequestMapping("/reservation")
public class TableReservationController {
    @Autowired
    private ITableReservationService tableReservationService;

    @PostMapping("/add-reservation/{userId}/{tableId}")
    public ConfirmTableReservationDetails addReservation(@RequestBody TableReservationDTO tableReservationDTO, @PathVariable Long userId, @PathVariable Long tableId){
        return tableReservationService.addReservation(tableReservationDTO, userId, tableId);
        
    }
}
