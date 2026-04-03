package com.project.fitness_tracker.repository;

import com.project.fitness_tracker.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, String> {
     //public Optional<Activity> findByEmail(String email);
}

