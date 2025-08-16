package com.smartparking.service;

import com.smartparking.model.Slot;

import java.time.LocalDateTime;
import java.util.List;

public interface SlotService {
    List<Slot> getAllSlots();
    List<Slot> getAvailableSlots(LocalDateTime start, LocalDateTime end);
}
