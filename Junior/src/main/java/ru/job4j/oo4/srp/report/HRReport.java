package ru.job4j.oo4.srp.report;

import ru.job4j.oo4.srp.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HRReport implements ReportEngine {

    /**
     * The method retrieves elements from a collection and converts them to String
     * with employees in descending order of salary
     * and without fields Hired and Fired.
     */
    @Override
    public String generate(List<Employee> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("Name; Salary;")
                .append(System.lineSeparator());
        list = list.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());
        for (Employee employee : list) {
            sb.append(employee.getName())
                    .append(";")
                    .append(String.format("%.2f руб", employee.getSalary()))
                    .append(";")
                    .append(System.lineSeparator());
        }
        System.out.println("HRReport:");
        System.out.println(sb.toString());
        return sb.toString();
    }
}
