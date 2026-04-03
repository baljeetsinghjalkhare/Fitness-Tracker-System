package com.project.fitness_tracker.service;

import com.project.fitness_tracker.dto.RegisterRequest;
import com.project.fitness_tracker.dto.UserResponse;
import com.project.fitness_tracker.model.User;
import com.project.fitness_tracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private static final Logger log= LoggerFactory.getLogger(UserResponse.class);

    private final UserRepository userRepository;

    public User register(RegisterRequest request)
    {

        log.info("UserService - register method executed:{}",request);

        User user=User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .build();


  /*      User user=new User(
                null,
                List.of(),
                List.of(),
                request.getEmail(),
                request.getPassword(),
                request.getFirstName(),
                request.getLastName(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
        */
//                Instant.parse("2026-04-02T15:30:45+00:00")
//                        .atZone(ZoneOffset.UTC)
//                .toLocalDateTime(),
//                Instant.parse("2026-04-02T15:30:45+00:00")
//                        .atZone(ZoneOffset.UTC)
//                        .toLocalDateTime()
 //       );


       return userRepository.save(user);
    }
}
/*

  new ArrayList<>(),
                new ArrayList<>(),
 */