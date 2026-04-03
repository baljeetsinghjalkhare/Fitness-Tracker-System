package com.project.fitness_tracker.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

@Data
public class UserResponse
{
    private static final Logger log= LoggerFactory.getLogger(UserResponse.class);

    private String id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UserResponse(String id, String email, String password, String firstName, String lastName, LocalDateTime createdAt, LocalDateTime updatedAt) {

        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;


        log.info("UserResponse - Constructur execute for UserResponse ");
    }
//    private boolean success;
//    private String message;
//    private Object data;
//
//    public UserResponse(boolean success, String message, Object data) {
//        this.success = success;
//        this.message = message;
//        this.data = data;
//    }
//
//    public UserResponse(boolean success, String message) {
//        this.success = success;
//        this.message = message;
//        this.data = null;
    }
