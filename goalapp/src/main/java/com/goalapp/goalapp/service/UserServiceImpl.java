package com.goalapp.goalapp.service;

import java.util.List;

import com.goalapp.goalapp.dto.User;
import com.goalapp.goalapp.exchanges.AddUserRequest;
import com.goalapp.goalapp.repositoryservices.UserRepositoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepositoryService userRepositoryService;

    @Override
    public User getUser(Long userId) {
        return userRepositoryService.getUser(userId);
    }

    @Override
    public User createUser(AddUserRequest user) {
        return userRepositoryService.createUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepositoryService.getAllUsers();
    }
    
}
