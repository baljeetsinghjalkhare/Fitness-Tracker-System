package com.project.fitness_tracker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@ToString(exclude = "activities")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToMany(mappedBy = "user", cascade=CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore // One-to-many relationship with Activity entities; cascades all operations (save/delete) and removes orphaned activities; ignored during JSON serialization to prevent infinite recursion.
    private List<Activity> activities=new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true )
    @JsonIgnore
    private List<Recommendation> recommendations=new ArrayList<>();


    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;


}
