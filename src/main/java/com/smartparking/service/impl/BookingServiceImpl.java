package com.smartparking.service.impl;

import com.smartparking.dto.BookingRequest;
import com.smartparking.dto.BookingRequestDto;
import com.smartparking.model.Booking;
import com.smartparking.model.Slot;
import com.smartparking.repository.BookingRepository;
import com.smartparking.repository.SlotRepository;
import com.smartparking.service.BookingService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private SlotRepository slotRepository;

    @Override
    public Booking bookSlot(BookingRequestDto request) {
        Slot slot = slotRepository.findById(request.getSlotId())
                .orElseThrow(() -> new IllegalArgumentException("Slot not found"));

        // Check for overlapping bookings
        List<Booking> existingBookings = bookingRepository.findBySlotAndEndTimeAfterAndStartTimeBefore(
                slot, request.getStartTime(), request.getEndTime());

        if (!existingBookings.isEmpty()) {
            throw new IllegalStateException("Slot is already booked during this time");
        }

        Booking booking = new Booking();
        booking.setSlot(slot);
        booking.setStartTime(request.getStartTime());
        booking.setEndTime(request.getEndTime());
        booking.setVehicleNumber(request.getVehicleNumber());

        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public void cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        bookingRepository.delete(booking);
    }
}
