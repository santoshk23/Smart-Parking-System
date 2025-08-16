package com.smartparking.controller.RoleBasedDashboard;

import com.smartparking.dto.SlotRequest;
import com.smartparking.model.ParkingLot;
import com.smartparking.model.Slot;
import com.smartparking.repository.ParkingLotRepository;
import com.smartparking.repository.SlotRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    private ParkingLotRepository parkingLotRepository;
    private SlotRepository slotRepository;

    @GetMapping("/dashboard")
    @PreAuthorize("hasAuthority('MANAGER')") // Only users with MANAGER role can access
    public ResponseEntity<String> getDashboard() {
        return ResponseEntity.ok("Welcome to Manager Dashboard!");
    }

}
