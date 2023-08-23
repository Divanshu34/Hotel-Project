package com.backend.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.daos.ILiveTableDAO;
import com.backend.daos.ITableDAO;
import com.backend.daos.ITableReservationDAO;
import com.backend.daos.IUserDAO;
import com.backend.dtos.ConfirmTableReservationDetails;
import com.backend.dtos.TableReservationDTO;
import com.backend.pojos.LiveTablePOJO;
import com.backend.pojos.TablePOJO;
import com.backend.pojos.TableReservationPOJO;
import com.backend.pojos.UserPOJO;
import com.backend.services.interfaces.ITableReservationService;

@Service
@Transactional
public class TableReservationService implements ITableReservationService {

    @Autowired
    private IUserDAO userDAO;
    @Autowired
    private ITableDAO tableDAO;
    @Autowired
    private ILiveTableDAO liveTableDAO;
    @Autowired
    private ITableReservationDAO tableReservationDAO;

    @Override
    public ConfirmTableReservationDetails addReservation(TableReservationDTO tableReservationDTO, Long userId,
            Long tableId) {
        UserPOJO userPOJO = userDAO.findById(userId).get();
        TablePOJO tablePOJO = tableDAO.findById(tableId).get();
        TableReservationPOJO tableReservationPOJO = new TableReservationPOJO();

        List<LiveTablePOJO> liveTablePOJOs = new ArrayList<>();

        for (LocalTime start = tableReservationDTO.getStartTime(); start != tableReservationDTO
                .getEndTime(); start = start.plusHours(1)) {

            LiveTablePOJO liveTablePOJO = liveTableDAO.findByStartTimeAndReservationDateAndTableReference(
                    start, tableReservationDTO.getReservationDate(), tablePOJO);

            if (liveTablePOJO.getAvailableSeats() <= 0L) {
                return new ConfirmTableReservationDetails();
            }

            liveTablePOJOs.add(liveTablePOJO);
        }

        LiveTablePOJO liveTablePOJO = Collections.min(liveTablePOJOs,
                (x, y) -> Long.compare(x.getAvailableSeats(), y.getAvailableSeats()));
        Long tableNo = liveTablePOJO.getAvailableSeats();
        for (LiveTablePOJO liveTablePOJO2 : liveTablePOJOs) {
            liveTablePOJO2.decreaseAvailableSeats();
            tableReservationPOJO.addTables(liveTablePOJO2);
        }
        tableReservationPOJO.setTableNo(tableNo);
        tableReservationPOJO.setUser(userPOJO);
        tableReservationDAO.save(tableReservationPOJO);
        return new ConfirmTableReservationDetails(tablePOJO.getTableType(),tableNo,tableReservationDTO.getStartTime(),tableReservationDTO.getEndTime(),tableReservationDTO.getReservationDate());
    }

}
