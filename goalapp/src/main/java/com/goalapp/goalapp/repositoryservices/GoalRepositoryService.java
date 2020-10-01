package com.goalapp.goalapp.repositoryservices;

import com.goalapp.goalapp.dto.Goal;
import com.goalapp.goalapp.exchanges.AddGoalRequest;
import com.goalapp.goalapp.models.GoalEntity;

public interface GoalRepositoryService {
    Goal addGoal(Long userId, AddGoalRequest goal);
    Goal deleteGoal (Long userId, Long goalId);
    GoalEntity getGoal(Long goalId);
}
