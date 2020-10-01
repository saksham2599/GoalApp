package com.goalapp.goalapp.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goal {
    private Long GoalId;
    @NotNull
    private String goalName;
    @NotNull
    private Integer targetAmount;
    private Integer currentAmount;
    private List<Transaction> transactions;
    private boolean isCompleted;
    private User user;

}
