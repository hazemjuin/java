package com.hazem.spring.hellohuman.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/greet")
    public String greet(
        @RequestParam(name = "name", defaultValue = "human") String name,
        @RequestParam(name = "last_name", required = false) String lastName,
        @RequestParam(name = "times", defaultValue = "1") int times) {

        StringBuilder greeting = new StringBuilder();
        
        for (int i = 0; i < times; i++) {
            greeting.append("Hello, ");
            greeting.append(name);
            
            if (lastName != null) {
                greeting.append(" ");
                greeting.append(lastName);
            }
            
            greeting.append("<br>");
        }

        return greeting.toString();
    }
}
