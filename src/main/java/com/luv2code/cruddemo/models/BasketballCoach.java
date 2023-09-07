package com.luv2code.cruddemo.models;

import org.springframework.stereotype.Component;

@Component
public class BasketballCoach implements ICoach {

    public BasketballCoach() {
        System.out.println("In constructor " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "it's dribble time";
    }
}