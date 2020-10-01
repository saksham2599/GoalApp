package com.goalapp.goalapp.repositories;

import com.goalapp.goalapp.models.GoalEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<GoalEntity, Long>{
    
}
