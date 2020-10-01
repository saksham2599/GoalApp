package com.goalapp.goalapp.dto;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private Long TransactionId;
    private Instant dateTime;
    private Long amount;
}
