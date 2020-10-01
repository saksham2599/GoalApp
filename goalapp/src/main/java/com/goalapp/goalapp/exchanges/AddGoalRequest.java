package com.goalapp.goalapp.exchanges;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddGoalRequest {
    @NotNull
    private String goalName;

    @NotNull
    @Min(1)
    private Integer targetAmount;
}
