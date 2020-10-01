package com.goalapp.goalapp.service;

import com.goalapp.goalapp.dto.Goal;
import com.goalapp.goalapp.exchanges.AddGoalRequest;


public interface GoalService {
    Goal addGoal(Long userId, AddGoalRequest addGoalRequest);
    Goal deleteGoal (Long userId, Long goalId);
}