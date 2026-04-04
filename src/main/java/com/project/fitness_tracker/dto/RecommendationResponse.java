package com.project.fitness_tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RecommendationResponse {
    private String Id;
    private String userId;
    private String activityId;
    private String type;
    private String recommendations;
    private List<String> improvements;
    private List<String> suggestions;
    private List<String> safety;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
