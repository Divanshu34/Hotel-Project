package com.backend.services.interfaces;

import com.backend.dtos.ConfirmTableReservationDetails;
import com.backend.dtos.TableReservationDTO;

public interface ITableReservationService {
    public ConfirmTableReservationDetails addReservation(TableReservationDTO tableReservationDTO, Long userId,
            Long tableId);}
