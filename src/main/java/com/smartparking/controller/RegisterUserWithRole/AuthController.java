package com.smartparking.controller.RegisterUserWithRole;

import com.smartparking.dto.AuthResponse;
import com.smartparking.dto.AuthenticationRequest;
import com.smartparking.model.User;
import com.smartparking.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationService authService;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody User user) {
        return authService.register(user);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthenticationRequest request) {
        return authService.login(request);
    }
}
