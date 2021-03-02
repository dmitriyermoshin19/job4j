package ru.job4j.oo4spring.di;

import org.springframework.stereotype.Component;

@Component
public class ConsoleInput {

    public void print(String str) {
        System.out.println(str);
    }
}
