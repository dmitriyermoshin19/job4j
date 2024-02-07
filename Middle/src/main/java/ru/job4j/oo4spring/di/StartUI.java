package ru.job4j.oo4spring.di;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

@Scope("prototype")
@Component
public class StartUI {
    @Autowired
    private Store store;
    @Autowired
    private ConsoleInput consoleInput;

    public void add(String value) {
        store.add(value);
    }

    public void print() {
        for (String value : store.getAll()) {
            consoleInput.print(value);
        }
    }
}
