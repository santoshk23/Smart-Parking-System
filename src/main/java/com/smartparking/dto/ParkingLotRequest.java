package com.smartparking.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParkingLotRequest {
    private String name;
    private String location;
    private List<SlotRequest> slots;
}
