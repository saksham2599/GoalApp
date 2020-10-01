package com.goalapp.goalapp.service;

import java.util.List;

import com.goalapp.goalapp.dto.Transaction;
import com.goalapp.goalapp.exchanges.TransactionRequest;
import com.goalapp.goalapp.exchanges.TransactionResponse;
import com.goalapp.goalapp.repositories.GoalRepository;

import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Override
    public List<Transaction> getAllTransactions(Long userId, Long goalId) {

        return null;
    }

    @Override
    public TransactionResponse makeTransaction(Long userId, Long goalId, TransactionRequest transcation) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
