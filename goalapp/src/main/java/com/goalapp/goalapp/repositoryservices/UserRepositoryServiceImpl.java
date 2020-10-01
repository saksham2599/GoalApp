package com.goalapp.goalapp.repositoryservices;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.goalapp.goalapp.dto.Goal;
import com.goalapp.goalapp.dto.User;
import com.goalapp.goalapp.exceptions.UserNotFoundException;
import com.goalapp.goalapp.exchanges.AddUserRequest;
import com.goalapp.goalapp.models.GoalEntity;
import com.goalapp.goalapp.models.UserEntity;
import com.goalapp.goalapp.repositories.UserRepository;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRepositoryServiceImpl implements UserRepositoryService {

    @Autowired
    private UserRepository userRepository;

    public User mapUserEntityToUser(UserEntity userEntity) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        
        User user = modelMapper.map(userEntity, User.class);
        
        Set<GoalEntity> goalEntities = userEntity.getGoals();
        Set<Goal> goals = new HashSet<Goal>();
        for(GoalEntity goalEntity : goalEntities) {
            goals.add(modelMapper.map(goalEntity, Goal.class));
        }
        user.setGoals(goals);

        return user;
    }

    public UserEntity getUserEntity(Long userId) {
        UserEntity userEntity = userRepository.findById(userId)
                                .orElseThrow(() -> new UserNotFoundException(userId));
        return userEntity;
    }


    @Override
    public User getUser(Long userId) {
        UserEntity userEntity = userRepository.findById(userId)
                                .orElseThrow(() -> new UserNotFoundException(userId));
        User user = mapUserEntityToUser(userEntity);
        return user;
    }

    @Override
    public User createUser(AddUserRequest addUser) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);

        UserEntity userEntity = modelMapper.map(addUser, UserEntity.class);
        userEntity.setGoals(new HashSet<GoalEntity>());

        UserEntity userCreated = userRepository.save(userEntity);
        User user = mapUserEntityToUser(userCreated);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);

        List<UserEntity> allUsers = userRepository.findAll();

        List<User> users = new ArrayList<User>();
        for(UserEntity userEntity : allUsers) {
            users.add(mapUserEntityToUser(userEntity));
        }

        return users;
        
    }

}
