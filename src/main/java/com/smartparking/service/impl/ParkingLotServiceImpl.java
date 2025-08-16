package com.smartparking.service.impl;

import com.smartparking.dto.ParkingLotRequest;
import com.smartparking.dto.SlotRequest;
import com.smartparking.model.ParkingLot;
import com.smartparking.model.Slot;
import com.smartparking.repository.ParkingLotRepository;
import com.smartparking.service.ParkingLotService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ParkingLotServiceImpl implements ParkingLotService {

    private final ParkingLotRepository lotRepository;

    @Override
    public ParkingLot addLot(ParkingLotRequest request) {
        // Convert SlotRequest DTOs to Slot entities
        List<Slot> slots = request.getSlots().stream()
                .map(s -> Slot.builder()
                        .type(Slot.SlotType.valueOf(s.getType()))
                        .code(s.getCode())     // <-- add this line to set code
                        .occupied(false)
                        .build())
                .collect(Collectors.toList());


        // Build ParkingLot entity
        ParkingLot lot = ParkingLot.builder()
                .name(request.getName())
                .location(request.getLocation())
                .slots(slots)
                .build();

        // Set parkingLot reference in each slot for bidirectional mapping
        lot.getSlots().forEach(slot -> slot.setParkingLot(lot));

        // Save the parking lot along with its slots (cascade)
        return lotRepository.save(lot);
    }

    @Override
    public List<ParkingLot> getAllLots() {
        return lotRepository.findAll();
    }
}
