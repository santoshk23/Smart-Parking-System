package com.smartparking.controller.RoleBasedDashboard;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @GetMapping("/dashboard")
    @PreAuthorize("hasAuthority('DRIVER')")
    public String driverDashboard() {
        return "Welcome to the DRIVER dashboard!";
    }
}
