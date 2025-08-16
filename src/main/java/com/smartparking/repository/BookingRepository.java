package com.smartparking.repository;

import com.smartparking.model.Booking;
import com.smartparking.model.Slot;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findBySlotAndEndTimeAfterAndStartTimeBefore(Slot slot, LocalDateTime start, LocalDateTime end);

}
