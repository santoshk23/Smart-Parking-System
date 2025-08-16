package com.smartparking.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code; // Example: A1, B2

    @Enumerated(EnumType.STRING)
    private SlotType type; // BIKE or CAR

    private boolean occupied;

    @ManyToOne
    @JoinColumn(name = "parking_lot_id")
    @JsonBackReference
    private ParkingLot parkingLot;

    public enum SlotType {
        CAR, BIKE
    }
}
