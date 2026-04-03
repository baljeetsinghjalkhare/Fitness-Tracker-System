package com.project.fitness_tracker.controller;

import com.project.fitness_tracker.dto.ActivityRequest;
import com.project.fitness_tracker.dto.ActivityResponse;
import com.project.fitness_tracker.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping
    public ResponseEntity<ActivityResponse> trackActivity(@RequestBody ActivityRequest request)
    {

        return ResponseEntity.ok(activityService.trackActivity(request));
        }

//    @GetMapping
//    public ResponseEntity<List<ActivityResponse>> getActivity(@PathVariable String email)
//    {
//        return "";
//      }
}
