package com.goalapp.goalapp.exchanges;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddUserRequest {
    @NotNull
    private String name;
    private String email;
}
