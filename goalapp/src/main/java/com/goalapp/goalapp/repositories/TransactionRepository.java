package com.goalapp.goalapp.repositories;

import com.goalapp.goalapp.models.TransactionEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
    
}
