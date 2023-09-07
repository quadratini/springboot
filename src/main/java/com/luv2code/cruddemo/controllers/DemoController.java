package com.luv2code.cruddemo.controllers;

import com.luv2code.cruddemo.models.ICoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private ICoach coach;
    private ICoach anotherCoach;

    @Autowired
    public DemoController(@Qualifier("basketballCoach") ICoach coach, @Qualifier("basketballCoach") ICoach anotherCoach) {
        System.out.println("In constructor " + getClass().getSimpleName());
        this.coach = coach;
        this.anotherCoach = anotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }

}
