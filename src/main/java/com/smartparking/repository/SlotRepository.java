package com.smartparking.repository;

import com.smartparking.model.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface SlotRepository extends JpaRepository<Slot, Long> {

    @Query("SELECT s FROM Slot s WHERE s.id NOT IN (" +
            "SELECT b.slot.id FROM Booking b " +
            "WHERE b.endTime > :start AND b.startTime < :end)")
    List<Slot> findAvailableSlots(LocalDateTime start, LocalDateTime end);

}
