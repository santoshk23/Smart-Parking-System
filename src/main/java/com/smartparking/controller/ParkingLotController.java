package com.smartparking.controller;

import com.smartparking.dto.ParkingLotRequest;
import com.smartparking.model.ParkingLot;
import com.smartparking.repository.ParkingLotRepository;
import com.smartparking.service.ParkingLotService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/manager/parking-lots")
@RequiredArgsConstructor
public class ParkingLotController {

    private final ParkingLotService parkingLotService;

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('MANAGER')")
    public ParkingLot createParkingLot(@RequestBody ParkingLotRequest parkingLot) {
        return parkingLotService.addLot(parkingLot);
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('MANAGER')")
    public List<ParkingLot> getAllParkingLots() {
        log.info("Getting parking lots");
        return parkingLotService.getAllLots();
    }
}
