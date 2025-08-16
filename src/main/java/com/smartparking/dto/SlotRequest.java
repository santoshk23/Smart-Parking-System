package com.smartparking.dto;

import com.smartparking.model.Slot;

import lombok.*;

@Data
public class SlotRequest {
    private String type;
    private String code;
}

