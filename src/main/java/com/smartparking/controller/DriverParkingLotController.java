package com.smartparking.controller;

import com.smartparking.model.ParkingLot;
import com.smartparking.service.ParkingLotService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/driver/parking-lots")
@RequiredArgsConstructor
public class DriverParkingLotController {

    private final ParkingLotService parkingLotService;

    @GetMapping("/available")
    @PreAuthorize("hasRole('MANAGER')")
    public List<ParkingLot> getAvailableParkingLots() {
        List<ParkingLot> allLots = parkingLotService.getAllLots();

        // Filter slots to only include unoccupied ones
        for (ParkingLot lot : allLots) {
            lot.setSlots(
                    lot.getSlots().stream()
                            .filter(slot -> !slot.isOccupied())
                            .collect(Collectors.toList())
            );
        }
        return allLots;
    }
}
