package com.luv2code.cruddemo.models;

import org.springframework.stereotype.Component;

/**
 * @Component tells spring that the class is a dependency and can be used for dependency injection (@Autowired).
 * Spring will determine which dependency to use when @Autowiring if there is only 1 dependency.
 * If there are multiple dependencies, @Qualifier needs to be used to tell Spring that's the dependency that needs to be used.
 * For example, if there is a BasketballCoach and CricketCoach dependency (both marked with @Component), Spring will not
 * know which one to use. Therefore, @Qualifier must be used when using @Autowire to inject, as @Qualifier has higher priority
 * and tells Spring which dependency to use when there are multiple.
 * Note: @Component tells Spring that this class is a Spring bean, which is just a regular Java class managed by spring.
 **/
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