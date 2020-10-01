package com.goalapp.goalapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Log4j2
public class GoalappApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoalappApplication.class, args);

		
		log.info("Congrats! Your GoalManagementApplication server has started");
	}

}
