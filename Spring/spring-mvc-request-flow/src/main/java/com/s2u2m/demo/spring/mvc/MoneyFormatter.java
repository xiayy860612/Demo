package com.s2u2m.demo.spring.mvc;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class MoneyFormatter implements Formatter<Money> {
    @Override
    public Money parse(String text, Locale locale) throws ParseException {
        String[] input = text.split(" ");
        Money money = new Money();
        if (input.length == 1) {
            money.setValue(input[0]);
        } else {
            money.setCurrency(input[0]);
            money.setValue(input[1]);
        }
        return money;
    }

    @Override
    public String print(Money object, Locale locale) {
        return object.getCurrency() + " " + object.getValue();
    }
}
