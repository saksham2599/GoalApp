package com.goalapp.goalapp.repositories;

import com.goalapp.goalapp.models.GoalEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository extends JpaRepository<GoalEntity, Long>{
    
}
