package com.goalapp.goalapp.repositoryservices;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.goalapp.goalapp.dto.Transaction;
import com.goalapp.goalapp.exchanges.TransactionRequest;
import com.goalapp.goalapp.exchanges.TransactionResponse;
import com.goalapp.goalapp.models.GoalEntity;
import com.goalapp.goalapp.models.TransactionEntity;
import com.goalapp.goalapp.repositories.GoalRepository;
import com.goalapp.goalapp.repositories.TransactionRepository;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionRepositoryServiceImpl implements TransactionRepositoryService {

    @Autowired
    private GoalRepositoryService goalRepositoryService;

    @Autowired
    private GoalRepository goalRepository;



    @Autowired 
    private TransactionRepository transactionRepository;

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

        Long currentAmount = goalEntity.getCurrentAmount();
        Long targetAmount = goalEntity.getTargetAmount();

        TransactionResponse  transactionResponse = new TransactionResponse();

        transactionResponse.setMessage("SUCCESSFUL");

        if( goalEntity.isCompleted() == true) {
            transactionResponse.setMessage("The Goal is already completed so further Transaction is not possible");
            transactionResponse.setStatus("FAILED");
            return transactionResponse;
        }
        else if(currentAmount < targetAmount && currentAmount + amount > targetAmount ) {
            amount = targetAmount - currentAmount;
            transactionResponse.setMessage("Amount +was more than the required amount for target. so transaction of" +
                                            amount +"is Done" );
            transactionResponse.setStatus("TRANSACTION_SUCCESSFUL_AMOUNT_EXCEEDED");
            Transaction transaction = makeTransactionNow(amount, goalEntity);
            transactionResponse.setTransaction(transaction);
        }
        else if(currentAmount + amount <= targetAmount) {
            transactionResponse.setMessage("Transaction of" +
                                            amount +"is Done" );
            transactionResponse.setStatus("TRANSACTION_SUCCESSFUL");
            Transaction transaction = makeTransactionNow(amount, goalEntity);
            transactionResponse.setTransaction(transaction);
        }

        return transactionResponse;
    }

    private Transaction makeTransactionNow(Long amount, GoalEntity goalEntity) {

        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setAmount(amount);
        transactionEntity.setDateTime(Instant.now());
        transactionEntity.setGoal(goalEntity);
        transactionEntity = transactionRepository.save(transactionEntity);

        Long currentAmount = goalEntity.getCurrentAmount();
        Long targetAmount = goalEntity.getTargetAmount();
        goalEntity.setCurrentAmount(currentAmount + amount);

        if(currentAmount >= targetAmount) {
            goalEntity.setCompleted(true);
        }

        Set<TransactionEntity> transactionEntities = goalEntity.getTransactions();
        transactionEntities.add(transactionEntity);
        goalRepository.save(goalEntity);

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);

        Transaction transaction = modelMapper.map(transactionEntity, Transaction.class);

        return transaction;
    }

    
}
