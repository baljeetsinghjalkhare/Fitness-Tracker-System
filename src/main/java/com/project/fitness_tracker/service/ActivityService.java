package com.project.fitness_tracker.service;

import com.project.fitness_tracker.dto.ActivityRequest;
import com.project.fitness_tracker.dto.ActivityResponse;
import com.project.fitness_tracker.model.Activity;
import com.project.fitness_tracker.model.User;
import com.project.fitness_tracker.repository.ActivityRepository;
import com.project.fitness_tracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ActivityService {
    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;

    public ActivityResponse trackActivity(ActivityRequest request)
    {
        User user=userRepository.findById(request.getUserId())
                .orElseThrow(()->new RuntimeException("invalid User: "+ request.getUserId()));

        Activity activity=Activity.builder()
                .id(null)
                .user(user)
                .type(request.getType())
                .additionalMetrics(request.getAdditionalMetrics())
                .duration(request.getDuration())
                .caloriesBurned(request.getCaloriesBurned())
                .startTime(request.getStartTime())
                .build();

    Activity savedActivity= activityRepository.save(activity);

    return mapToResponseActivity(savedActivity);
    }

    private ActivityResponse mapToResponseActivity(Activity activity)
    {
        ActivityResponse activityResponse=new ActivityResponse();

        activity.setId(activity.getId());
        activityResponse.setUserId(activity.getUser().getId());
        activityResponse.setType(activity.getType());
        activityResponse.setAdditionalMetrics(activity.getAdditionalMetrics());
        activityResponse.setDuration(activity.getDuration());
        activityResponse.setCaloriesBurned(activity.getCaloriesBurned());
        activityResponse.setStartTime(activity.getStartTime());
        activityResponse.setCreatedAt(activity.getCreatedAt());
        activityResponse.setStartTime(activity.getUpdatedAt());

        return activityResponse;
    }


//    public Activity getActivity(String email)
//    {
//        return userRepository.getByEmail(email);
//
//    }

    }
