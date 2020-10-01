package com.goalapp.goalapp.repositoryservices;

import java.util.List;

import com.goalapp.goalapp.dto.Transaction;
import com.goalapp.goalapp.exchanges.TransactionRequest;
import com.goalapp.goalapp.exchanges.TransactionResponse;

public interface TransactionRepositoryService {
    List<Transaction> getTransactions (Long userId, Long goalId);
    TransactionResponse makeTransaction(Long userId, Long goalId, TransactionRequest transcation);
}
