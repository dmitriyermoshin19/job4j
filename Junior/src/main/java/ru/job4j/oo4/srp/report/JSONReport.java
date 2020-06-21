package ru.job4j.oo4.srp.report;

import com.google.gson.Gson;
import ru.job4j.oo4.srp.Employee;

import java.util.List;

public class JSONReport implements ReportEngine {

    /**
     * The method retrieves elements from a collection and converts them to String in JSON.
     */
    @Override
    public String generate(List<Employee> list) {
        StringBuilder sb = new StringBuilder();
        Gson gson = new Gson();
        for (Employee emp : list) {
            sb.append(gson.toJson(emp));
        }
        System.out.println("JSONReport:");
        System.out.println(sb.toString());
        return sb.toString();
    }
}
