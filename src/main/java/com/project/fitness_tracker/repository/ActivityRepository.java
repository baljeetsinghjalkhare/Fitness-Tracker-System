package com.project.fitness_tracker.repository;

import com.project.fitness_tracker.model.Activity;
import com.project.fitness_tracker.model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, String> {
  public  List<Activity> findBy(String id);

    List<Activity> findByUserId(String userId);
}

