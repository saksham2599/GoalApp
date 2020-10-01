package com.goalapp.goalapp.service;

import java.util.List;

import com.goalapp.goalapp.dto.Transaction;
import com.goalapp.goalapp.exchanges.TransactionRequest;
import com.goalapp.goalapp.exchanges.TransactionResponse;
import com.goalapp.goalapp.repositoryservices.TransactionRepositoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepositoryService transactionRepositoryService;

    @Override
    public List<Transaction> getTransactions(Long userId, Long goalId) {

        return transactionRepositoryService.getTransactions(userId, goalId);
    }

    @Override
    public TransactionResponse makeTransaction(Long userId, Long goalId, TransactionRequest transcation) {
        
        return transactionRepositoryService.makeTransaction(userId, goalId, transcation);
    }
    
}
