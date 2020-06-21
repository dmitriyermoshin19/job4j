package ru.job4j.oo4.srp.report;

import ru.job4j.oo4.srp.Employee;
import java.util.List;

public class AccountantsReport implements ReportEngine {

    /**
     * The method retrieves elements from a collection and converts them to String
     * with a different type of salary.
     */
    @Override
    public String generate(List<Employee> list) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        text.append(System.lineSeparator());
        for (Employee employee : list) {
            text.append(employee.getName())
                    .append(";")
                    .append(employee.getHired().toString())
                    .append(";")
                    .append(employee.getFired().toString())
                    .append(";")
                    .append(String.format("%.2f руб", employee.getSalary()))
                    .append(";")
                    .append(System.lineSeparator());
        }
        System.out.println("AccountantsReport:");
        System.out.println(text.toString());
        return text.toString();
    }
}
