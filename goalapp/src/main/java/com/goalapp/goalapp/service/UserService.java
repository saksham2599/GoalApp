package com.goalapp.goalapp.service;

import java.util.List;

import com.goalapp.goalapp.dto.User;
import com.goalapp.goalapp.exchanges.AddUserRequest;

public interface UserService {
    User getUser(Long userId);
    User createUser(AddUserRequest user);
    List<User> getAllUsers();

}
