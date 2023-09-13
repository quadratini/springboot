package com.luv2code.cruddemo.controllers;

import com.luv2code.cruddemo.models.ICoach;
import com.luv2code.cruddemo.security.DemoSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class DemoController {

    private ICoach coach;
    private ICoach anotherCoach;

    // @Autowired is optional when only 1 constructor present. @Autowired tells spring to inject a dependency.
    // @Qualifier tells Spring which dependency to inject.
    @Autowired
    public DemoController(@Qualifier("basketballCoach") ICoach coach, @Qualifier("cricketCoach") ICoach anotherCoach) {
        System.out.println("In constructor " + getClass().getSimpleName());
        this.coach = coach;
        this.anotherCoach = anotherCoach;
    }

    public DemoController(ICoach coach) {
        System.out.println("In constructor " + getClass().getSimpleName());
        this.coach = coach;
        this.anotherCoach = anotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }

}
