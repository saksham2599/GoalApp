package com.goalapp.goalapp.repositoryservices;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.goalapp.goalapp.dto.Transaction;
import com.goalapp.goalapp.exchanges.TransactionRequest;
import com.goalapp.goalapp.exchanges.TransactionResponse;
import com.goalapp.goalapp.models.GoalEntity;
import com.goalapp.goalapp.models.TransactionEntity;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class TransactionRepositoryServiceImpl implements TransactionRepositoryService {

    @Autowired
    private GoalRepositoryService goalRepositoryService;

    @Override
    public List<Transaction> getTransactions(Long userId, Long goalId) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);

        GoalEntity goalEntity = goalRepositoryService.getGoal(goalId);
        Set<TransactionEntity> transactionEntities = goalEntity.getTransactions();

        List<Transaction> transactions = new ArrayList<Transaction>();
        
        for(TransactionEntity transactionEntity : transactionEntities) {
            transactions.add(modelMapper.map(transactionEntity, Transaction.class));
        }

        return transactions;
    }

    @Override
    public TransactionResponse makeTransaction(Long userId, Long goalId, TransactionRequest transactionRequest) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);

        GoalEntity goalEntity = goalRepositoryService.getGoal(goalId);

        long amount = transactionRequest.getAmount();

        int currentAmount = goalEntity.getCurrentAmount();
        int targetAmount = goalEntity.getTargetAmount();

        TransactionResponse  transactionResponse = new TransactionResponse();

        if(currentAmount + amount <= targetAmount) {
            
        }

        return null;
    }

    
}
