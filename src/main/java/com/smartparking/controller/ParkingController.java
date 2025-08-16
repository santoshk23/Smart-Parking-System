package com.smartparking.controller;

import com.smartparking.dto.ParkingLotRequest;
import com.smartparking.model.ParkingLot;
import com.smartparking.service.ParkingLotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lots")
@RequiredArgsConstructor
public class ParkingController {

    private final ParkingLotService lotService;

    @PostMapping
    public ParkingLot create(@RequestBody ParkingLotRequest request) {
        return lotService.addLot(request);
    }

    @GetMapping
    public List<ParkingLot> getAll() {
        return lotService.getAllLots();
    }
}
