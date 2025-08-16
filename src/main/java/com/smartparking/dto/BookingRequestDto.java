package com.smartparking.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDateTime;

public class BookingRequestDto {

    @NotNull(message = "Slot ID is required")
    private Long slotId;

    @NotNull(message = "Vehicle number is required")
    @Pattern(regexp = "^[A-Z0-9-]+$", message = "Invalid vehicle number format")
    private String vehicleNumber;

    @NotNull(message = "Start time is required")
    @Future(message = "Start time must be in the future")
    private LocalDateTime startTime;

    @NotNull(message = "End time is required")
    @Future(message = "End time must be in the future")
    private LocalDateTime endTime;

    // Getters and setters
    public Long getSlotId() {
        return slotId;
    }
    public void setSlotId(Long slotId) {
        this.slotId = slotId;
    }
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
