package com.luv2code.cruddemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DemoThymeleafController {

    // create a mapping for "/hello"
    @GetMapping("/hello")
    public String sayHello(Model model) {
        model.addAttribute("date", new java.util.Date());

        return "helloworld";
    }

    // delete later, just for leetcode fun
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<String>();

        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0 && i % 3 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(i + "");
            }
        }

        return result;
    }
}
