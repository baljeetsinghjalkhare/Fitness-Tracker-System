package com.project.fitness_tracker.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
@Setter
@Getter
public class RegisterRequest {

    private static final Logger log= LoggerFactory.getLogger(UserResponse.class);

    private String email;
    private String password;
    private String firstName;
    private String lastName;

    public RegisterRequest(String email, String password, String firstName, String lastName) {

        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;

        log.info("RegisterRequest - Extract Data from request ");

    }
}

