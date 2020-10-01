package com.goalapp.goalapp.controller;

import java.util.List;

import javax.validation.Valid;

import com.goalapp.goalapp.dto.Goal;
import com.goalapp.goalapp.dto.Transaction;
import com.goalapp.goalapp.dto.User;
import com.goalapp.goalapp.exchanges.AddGoalRequest;
import com.goalapp.goalapp.exchanges.TransactionRequest;
import com.goalapp.goalapp.exchanges.TransactionResponse;
import com.goalapp.goalapp.service.GoalService;
import com.goalapp.goalapp.service.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
public class TransactionController {
    public static final String TRANSACTION_API = "/user/{userId}/goal/{goalId}/transaction";

    @Autowired
    private TransactionService transactionService;

    @GetMapping(TRANSACTION_API+"/all")
    public ResponseEntity<List<Transaction>> getAllTransactions(
        @PathVariable("userId") long userId, @PathVariable("goalId") long goalId) {
            List<Transaction> transactions;
            transactions = transactionService.getAllTransactions(userId, goalId);

            return ResponseEntity.ok().body(transactions); 
    }

    @PostMapping(TRANSACTION_API)
    public ResponseEntity<TransactionResponse> makeTransaction (
        @PathVariable("userId") long userId, @PathVariable("goalId") long goalId,
        @Valid @RequestBody TransactionRequest transcationRequest) {
        
        TransactionResponse transactionResponse;
        transactionResponse = transactionService.makeTransaction(userId, goalId, transcationRequest);

        return ResponseEntity.ok().body(transactionResponse);

    }


    

}