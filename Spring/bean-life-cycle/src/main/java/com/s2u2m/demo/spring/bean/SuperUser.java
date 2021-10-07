package com.s2u2m.demo.spring.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class SuperUser extends User {
    public SuperUser() {
        super();
        System.out.println("SuperUser create");
    }
}
