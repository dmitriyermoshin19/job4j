package ru.job4j.oo4.srp;

import java.util.List;
import java.util.function.Predicate;

/**
 * Access to a database
 */
public interface Store {
    List<Employee> findBy(Predicate<Employee> filter);
}
