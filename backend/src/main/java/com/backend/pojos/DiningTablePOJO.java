package com.backend.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.backend.pojos.enums.TableType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "dining_table")
public class DiningTablePOJO{
    @Id
    @Column(name = "table_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tableId;

    @Enumerated(EnumType.STRING)
    @Column(name = "table_type")
    private TableType tableType;  

    @Column(name = "price")
    private Double price;

    @Column(name = "seats")
    private Long seats;

    @JoinColumn(name = "room_id")
    @ManyToOne
    private DiningVenuePOJO diningVenue;

    @Column(name = "room_image")
    private byte[] roomImage;

}