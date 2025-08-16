package com.smartparking.service;

import com.smartparking.dto.BookingRequestDto;
import com.smartparking.model.Booking;
import java.util.List;

public interface BookingService {

    Booking bookSlot(BookingRequestDto request);

    List<Booking> getBookings();

    void cancelBooking(Long bookingId);
}
