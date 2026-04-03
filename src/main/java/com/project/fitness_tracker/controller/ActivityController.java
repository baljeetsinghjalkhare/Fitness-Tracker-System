package com.project.fitness_tracker.controller;

import com.project.fitness_tracker.dto.ActivityRequest;
import com.project.fitness_tracker.dto.ActivityResponse;
import com.project.fitness_tracker.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    private static final Logger log= LoggerFactory.getLogger(ActivityController.class);

    private final ActivityService activityService;

    @PostMapping
    public ResponseEntity<ActivityResponse> trackActivity(@RequestBody ActivityRequest request)
    {

        return ResponseEntity.ok(activityService.trackActivity(request));
        }

    @GetMapping //("/{id}") using path variable to fetch activity of specific user
    public ResponseEntity<List<ActivityResponse>> getUserActivity(@RequestHeader(value = "X-User-Id") String id) {
        log.info("ActivityController - getUserActivity method invoked execute for user_id:{}",id);
        return ResponseEntity.ok(activityService.getUserActivity(id));
      }
}
