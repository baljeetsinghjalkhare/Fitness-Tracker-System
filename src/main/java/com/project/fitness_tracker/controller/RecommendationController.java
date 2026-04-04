package com.project.fitness_tracker.controller;

import com.project.fitness_tracker.dto.RecommendationRequest;
import com.project.fitness_tracker.dto.RecommendationResponse;
import com.project.fitness_tracker.model.Recommendation;
import com.project.fitness_tracker.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/recommendation")
public class RecommendationController {

    private static final Logger log = LoggerFactory.getLogger(RecommendationController.class);
    private final RecommendationService recommendationService;

    @PostMapping("/generate")
    public ResponseEntity<Recommendation> generateRecommendation(
            @RequestBody RecommendationRequest request) {

        log.info("Received recommendation request for userId: {}, activityId: {}", request.getUserId(), request.getActivityId());
        // Placeholder for recommendation generation logic
        return ResponseEntity.ok(recommendationService.generateRecommendation(request));
    }

    @GetMapping("/user")  //take activityId through RequestHeader
    public ResponseEntity<List<RecommendationResponse>> getUserRecommendation(@RequestHeader(value = "X-User-Id") String id)
    {
     return ResponseEntity.ok(recommendationService.getUserRecommendation(id));
    }

    @GetMapping("/activity/{activityId}")// take activityId through PAthVariable
     public ResponseEntity<List<RecommendationResponse>> getActivityRecommendation(@PathVariable String activityId)
    {
     return ResponseEntity.ok(recommendationService.getActivityRecommendation(activityId));
    }
}
