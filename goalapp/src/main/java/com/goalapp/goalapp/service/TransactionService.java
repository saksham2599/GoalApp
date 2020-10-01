package com.goalapp.goalapp.service;

import java.util.List;

import com.goalapp.goalapp.dto.Transaction;
import com.goalapp.goalapp.exchanges.TransactionRequest;
import com.goalapp.goalapp.exchanges.TransactionResponse;

public interface TransactionService {
    List<Transaction> getAllTransactions (Long userId, Long goalId);
    TransactionResponse makeTransaction(Long userId, Long goalId, TransactionRequest transcation);
}
