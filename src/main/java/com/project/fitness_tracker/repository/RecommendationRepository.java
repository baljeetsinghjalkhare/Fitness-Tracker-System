package com.project.fitness_tracker.repository;

import com.project.fitness_tracker.model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationRepository extends JpaRepository<Recommendation, String> {
}
