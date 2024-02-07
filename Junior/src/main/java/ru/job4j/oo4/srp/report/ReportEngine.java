package ru.job4j.oo4.srp.report;

import ru.job4j.oo4.srp.Employee;

import java.util.List;

/**
 * Basic interface for different reports
 */
public interface ReportEngine {
    String generate(List<Employee> list);
}
