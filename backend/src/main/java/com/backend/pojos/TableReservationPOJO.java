package com.backend.pojos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "table_reservation")
public class TableReservationPOJO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    private LocalDateTime startTime;
    // private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserPOJO user;

    @ManyToOne
    @JoinColumn(name = "table_id")
    private DiningTablePOJO diningTable;

}
