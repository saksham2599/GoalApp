package com.goalapp.goalapp.service;

import com.goalapp.goalapp.dto.Goal;
import com.goalapp.goalapp.exchanges.AddGoalRequest;
import com.goalapp.goalapp.repositoryservices.GoalRepositoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoalServiceImpl implements GoalService {

    @Autowired
    private GoalRepositoryService goalRepositoryService;

    @Override
    public Goal addGoal(Long userId, AddGoalRequest goal) {
        return goalRepositoryService.addGoal(userId, goal);
    }

    @Override
    public Goal deleteGoal(Long userId, Long goalId) {
        return deleteGoal(userId, goalId);
    }

    
}
