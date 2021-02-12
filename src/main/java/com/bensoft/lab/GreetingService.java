package com.bensoft.lab;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String greet() {
        return "greeting";
    }

    public String getName(String name) {
        return name;
    }
}