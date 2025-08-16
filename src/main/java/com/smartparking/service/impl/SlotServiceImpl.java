package com.smartparking.service.impl;

import com.smartparking.model.Slot;
import com.smartparking.repository.SlotRepository;
import com.smartparking.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SlotServiceImpl implements SlotService {

    @Autowired
    private SlotRepository slotRepository;

    @Override
    public List<Slot> getAllSlots() {
        return slotRepository.findAll();
    }

    @Override
    public List<Slot> getAvailableSlots(LocalDateTime start, LocalDateTime end) {
        return slotRepository.findAvailableSlots(start, end);
    }
}
