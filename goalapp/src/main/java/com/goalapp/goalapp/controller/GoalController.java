package com.goalapp.goalapp.controller;

import javax.validation.Valid;

import com.goalapp.goalapp.dto.Goal;
import com.goalapp.goalapp.dto.User;
import com.goalapp.goalapp.exchanges.AddGoalRequest;
import com.goalapp.goalapp.service.GoalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping("/goalapp/v1")
public class GoalController {
    public static final String GOAL_API = "/user/{userId}/goal/";

    @Autowired
    private GoalService goalService;

    @PostMapping(GOAL_API) 
    public ResponseEntity<Goal> addGoal(
        @PathVariable("userId") long userId,@Valid @RequestBody AddGoalRequest addGoalRequest) {
          
          Goal goal = goalService.addGoal(userId, addGoalRequest);
          return ResponseEntity.ok().body(goal);
    }

    @DeleteMapping(GOAL_API+ "/{goalId}") 
    public ResponseEntity<Goal> deleteGoal(
        @PathVariable("userId") long userId, @PathVariable("goalId") long goalId) {
          Goal goal = goalService.deleteGoal(userId, goalId);
          return ResponseEntity.ok().body(goal);
    }





}
