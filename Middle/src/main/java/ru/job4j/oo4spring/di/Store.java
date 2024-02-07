package ru.job4j.oo4spring.di;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;

@Scope("prototype")
@Component
public class Store {
    private List<String> data = new ArrayList<String>();

    public void add(String value) {
        data.add(value);
    }

    public List<String> getAll() {
        return data;
    }
}
