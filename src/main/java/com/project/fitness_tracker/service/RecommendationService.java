package com.project.fitness_tracker.service;

import com.project.fitness_tracker.dto.RecommendationRequest;
import com.project.fitness_tracker.model.Activity;
import com.project.fitness_tracker.model.Recommendation;
import com.project.fitness_tracker.model.User;
import com.project.fitness_tracker.repository.ActivityRepository;
import com.project.fitness_tracker.repository.RecommendationRepository;
import com.project.fitness_tracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RecommendationService {


    private static final Logger log= LoggerFactory.getLogger(RecommendationService.class);
    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;
    private final RecommendationRepository  recommendationRepository;

    public Recommendation generateRecommendation(RecommendationRequest request)
    {

        User user =userRepository.findById(request.getUserId())
                .orElseThrow(()-> new RuntimeException("User not found with id: "+request.getUserId()));

        log.info("Generating recommendation for user: {}", user.getId());

        Activity activity=activityRepository.findById(request.getActivityId())
                .orElseThrow(()-> new RuntimeException("Activity not found with id: "+request.getActivityId()));

        log.info("Generating recommendation for activity: {}", activity.getId());
        Recommendation recommendation=Recommendation.builder()
                .user(user)
                .activity(activity)
                .improvements(request.getImprovements())
                .suggestions(request.getSuggestions())
                .safety(request.getSafety())
                .build();


       return recommendationRepository.save(recommendation);


    }
}
