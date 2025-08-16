package com.smartparking.service;

import com.smartparking.dto.ParkingLotRequest;
import com.smartparking.model.ParkingLot;

import java.util.List;

public interface ParkingLotService {
    ParkingLot addLot(ParkingLotRequest request);
    List<ParkingLot> getAllLots();
}
