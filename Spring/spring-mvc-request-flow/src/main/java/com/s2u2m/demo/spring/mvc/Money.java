package com.s2u2m.demo.spring.mvc;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Money {
    private String currency = "CNY";
    private String value;
}
