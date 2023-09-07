package com.luv2code.cruddemo.models;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements ICoach {

    public CricketCoach() {
        System.out.println("In constructor " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "What is cricket anyway?";
    }
}