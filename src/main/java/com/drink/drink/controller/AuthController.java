package com.drink.drink.controller;

import com.drink.drink.dto.auth.AuthRequest;
import com.drink.drink.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;


    @PostMapping("/login")
    public ResponseEntity<String> auth(@RequestBody AuthRequest request) {
        return ResponseEntity.ok()
                .header("Authorization", userService.generateToken(request.getEmail(), request.getPassword()))
                .body("Auth");
    }
}
