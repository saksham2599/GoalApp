package com.goalapp.goalapp.exceptions;

public class GoalNotFoundException extends RuntimeException{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public GoalNotFoundException(Long id) {
        super("Could not find goal " + id);
    }
}
