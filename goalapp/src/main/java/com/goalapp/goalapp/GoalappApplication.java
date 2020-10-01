package com.goalapp.goalapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lombok.extern.log4j.Log4j2;


//@EnableTransactionManagement
@SpringBootApplication
@Log4j2
@EnableAutoConfiguration
@ComponentScan(basePackages={"service", "repositoryservices"})
@EnableJpaRepositories(basePackages="repositories")
@EntityScan(basePackages="models")
public class GoalappApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoalappApplication.class, args);
		
		log.info("Congrats! Your GoalManagementApplication server has started");
	}

}
