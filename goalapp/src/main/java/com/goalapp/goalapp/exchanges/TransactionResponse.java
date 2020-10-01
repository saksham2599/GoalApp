package com.goalapp.goalapp.exchanges;

import com.goalapp.goalapp.dto.Transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {
    Transaction transaction;
    String message;
    String status;
}

enum Status {
    SUCCESSFUL, AMOUNT_EXCEEDED, FAILED;
}
