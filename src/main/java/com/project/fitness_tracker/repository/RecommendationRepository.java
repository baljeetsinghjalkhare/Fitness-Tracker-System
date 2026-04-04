package com.project.fitness_tracker.repository;

import com.project.fitness_tracker.model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommendationRepository extends JpaRepository<Recommendation, String> {

    List<Recommendation> findByUserId(String id);
//    List<Recommendation> findByActivityId(String id);

}
