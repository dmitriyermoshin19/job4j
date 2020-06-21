package ru.job4j.oo4.srp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Database as MemStore - List<Employee>
 */
public class MemStore implements Store {
    private final List<Employee> employees = new ArrayList<>();

    public void add(Employee em) {
        this.employees.add(em);
    }

    @Override
    public List<Employee> findBy(Predicate<Employee> filter) {
        return this.employees.stream().filter(filter).collect(Collectors.toList());
    }
}
