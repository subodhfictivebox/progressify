package com.example.progressify.repository;

import com.example.progressify.entity.Exercise_Workout;
import com.example.progressify.entity.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseWorkoutRepository extends JpaRepository<Exercise_Workout, Long> {

    List<Exercise_Workout> findByWorkout(Workout workout);
}
