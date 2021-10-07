package com.s2u2m.demo.spring.bean;

import org.springframework.stereotype.Component;

@Component
public class UserHolder {
    private User user;
    public UserHolder(User user) {
        System.out.println("UserHolder create with " + user.getClass().getName());
        this.user = user;
    }
}
