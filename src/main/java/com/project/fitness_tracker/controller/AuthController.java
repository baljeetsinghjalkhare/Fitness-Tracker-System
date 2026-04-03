package com.project.fitness_tracker.controller;
import com.project.fitness_tracker.dto.RegisterRequest;
import com.project.fitness_tracker.dto.UserResponse;
import com.project.fitness_tracker.model.User;
import com.project.fitness_tracker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private static final Logger log= LoggerFactory.getLogger(UserResponse.class);

    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest request)
    {
        log.info("AuthController - register method invoked execute:{}",request);

        return ResponseEntity.ok(userService.register(request));
    }



}
