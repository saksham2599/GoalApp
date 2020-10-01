package com.goalapp.goalapp.repositoryservices;

import java.util.List;

import com.goalapp.goalapp.dto.User;
import com.goalapp.goalapp.exchanges.AddUserRequest;
import com.goalapp.goalapp.models.UserEntity;

public interface UserRepositoryService {
    User getUser(Long userId);
    User createUser(AddUserRequest user);
    List<User> getAllUsers();
	UserEntity getUserEntity(Long userId);
}
