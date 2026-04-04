package com.project.fitness_tracker.service;

import com.project.fitness_tracker.dto.ActivityRequest;
import com.project.fitness_tracker.dto.ActivityResponse;
import com.project.fitness_tracker.dto.UserResponse;
import com.project.fitness_tracker.model.Activity;
import com.project.fitness_tracker.model.User;
import com.project.fitness_tracker.repository.ActivityRepository;
import com.project.fitness_tracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ActivityService {

    private static final Logger log = LoggerFactory.getLogger(ActivityService.class);

    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;


    //Post activities

    public ActivityResponse trackActivity(ActivityRequest request) {

        log.info("ActivityService - trackActivity method executed ActivityRequest:{}", request);
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("invalid User: " + request.getUserId()));

        log.info("ActivityService - Fetch User by Id,  User:{}", user);
        Activity activity = Activity.builder()
                .user(user)
                .type(request.getType())
                .additionalMetrics(request.getAdditionalMetrics())
                .duration(request.getDuration())
                .caloriesBurned(request.getCaloriesBurned())
                .startTime(request.getStartTime())
                .build();

        log.info("ActivityService - Activity added corresponding to user_id, Activity:{}", activity);

        Activity savedActivity = activityRepository.save(activity);

        log.info("ActivityService - Activity Stored in DB, Activity:{}", savedActivity);

        return mapToActivityResponse(savedActivity);
    }

    //methodfor converting Activity to ActivityResponse
    private ActivityResponse mapToActivityResponse(Activity activity) {

        log.info("ActivityService - mapToActivityResponse executed, Activity:{}", activity);

        ActivityResponse activityResponse = new ActivityResponse();

        activityResponse.setId(activity.getId());
        activityResponse.setUserId(activity.getUser().getId());
        activityResponse.setType(activity.getType());
        activityResponse.setAdditionalMetrics(activity.getAdditionalMetrics());
        activityResponse.setDuration(activity.getDuration());
        activityResponse.setCaloriesBurned(activity.getCaloriesBurned());
        activityResponse.setStartTime(activity.getStartTime());
        activityResponse.setCreatedAt(activity.getCreatedAt());
        activityResponse.setStartTime(activity.getUpdatedAt());

        log.info("ActivityService - mapToActivityResponse executed, ActivityResponse:{}", activityResponse);
        return activityResponse;
    }


    // Get activitipes

    public List<ActivityResponse> getUserActivity(String id) {

        log.info("ActivityService - getUserActivity method executed, UserId:{}", id);

        List<Activity> activities = activityRepository.findByUserId(id);
        log.info("ActivityService - Activities Fetch from DB Activities:{}", activities);

        return activities
                .stream()
                .map(this::mapToActivityResponse)
                .collect(Collectors.toList());
    }
}


//
//    private List<ActivityResponse> mapToActivityResponse(List<Activity> activities) {
//
//        log.info("ActivityService - mapToActivityResponse executed, Activities List:{}",activities);
//
//        List<ActivityResponse> activityResponseList= activities
//                .stream()
//                .map( activity -> {
//                            ActivityResponse activityResponse = new ActivityResponse();
//                            activityResponse.setId(activity.getId());
//                            activityResponse.setUserId(activity.getUser().getId());
//                            activityResponse.setType(activity.getType());
//                            activityResponse.setAdditionalMetrics(activity.getAdditionalMetrics());
//                            activityResponse.setDuration(activity.getDuration());
//                            activityResponse.setCaloriesBurned(activity.getCaloriesBurned());
//                            activityResponse.setStartTime(activity.getStartTime());
//                            activityResponse.setCreatedAt(activity.getCreatedAt());
//                            activityResponse.setUpdatedAt(activity.getUpdatedAt());
//                            return activityResponse;
//                        })
//                        .toList();
//
//        log.info("ActivityService - mapToActivityResponse executed, ActivityResponse List:{}",activityResponseList);
//        return activityResponseList;
//    }
//}

