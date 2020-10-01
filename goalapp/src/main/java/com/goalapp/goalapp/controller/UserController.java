package com.goalapp.goalapp.controller;

import java.util.List;

import javax.validation.Valid;

import com.goalapp.goalapp.dto.User;
import com.goalapp.goalapp.exchanges.AddUserRequest;
import com.goalapp.goalapp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public class UserController {
    public static final String USER_API = "/user";


    @Autowired
    private UserService userService;

    @PostMapping(USER_API)
    public ResponseEntity<User> addUser(
        @Valid @RequestBody AddUserRequest addUser) {
          
      log.info("addUser called with {}", addUser);

      User user = userService.createUser(addUser);

      return ResponseEntity.ok().body(user);
    }

    @GetMapping(USER_API+"/{id}")
    public ResponseEntity<User> addUser(@PathVariable("id") long userId) {
        User user = userService.getUser(userId);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping(USER_API+"/all") 
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok().body(users);
    }


}
