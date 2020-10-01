package com.goalapp.goalapp.repositoryservices;

import java.util.HashSet;

import com.goalapp.goalapp.dto.Goal;
import com.goalapp.goalapp.exceptions.GoalNotFoundException;
import com.goalapp.goalapp.exchanges.AddGoalRequest;
import com.goalapp.goalapp.models.GoalEntity;
import com.goalapp.goalapp.models.TransactionEntity;
import com.goalapp.goalapp.models.UserEntity;
import com.goalapp.goalapp.repositories.GoalRepository;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoalRepositoryServiceImpl implements GoalRepositoryService {

    @Autowired
    private UserRepositoryService userRepositoryService;

    @Autowired
    private GoalRepository goalRepository;

    @Override
    public Goal addGoal(Long userId, AddGoalRequest addGoalRequest) {
        UserEntity userEntity = userRepositoryService.getUserEntity(userId);
        GoalEntity goalEntity = new GoalEntity();

        goalEntity.setGoalName(addGoalRequest.getGoalName());
        goalEntity.setTargetAmount(addGoalRequest.getTargetAmount());
        goalEntity.setTransactions(new HashSet<TransactionEntity>());
        goalEntity.setCurrentAmount((long)0);
        goalEntity.setCompleted(false);
        goalEntity.setUser(userEntity);

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);

        Goal goal = modelMapper.map(goalRepository.save(goalEntity), Goal.class);

        return goal;
    }

    @Override
    public Goal deleteGoal(Long userId, Long goalId) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);

        Goal goal = modelMapper.map(goalRepository.findById(goalId), Goal.class);
        goalRepository.deleteById(goalId);
        return goal;
    }

    @Override
    public GoalEntity getGoal(Long goalId) {
        GoalEntity goalEntity = goalRepository.findById(goalId)
                                .orElseThrow(() -> new GoalNotFoundException(goalId));
        return goalEntity;
    }
    
}
