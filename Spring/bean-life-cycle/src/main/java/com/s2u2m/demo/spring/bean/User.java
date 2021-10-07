package com.s2u2m.demo.spring.bean;

import org.springframework.stereotype.Component;

@Component
public class User {
    public User() {
        System.out.println("User create for " + this.getClass().getName());
    }
}
