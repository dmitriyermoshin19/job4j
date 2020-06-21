package ru.job4j.oo4.srp.report;

import ru.job4j.oo4.srp.Employee;
import java.util.List;

public class ITReport implements ReportEngine {

    /**
     * The method retrieves elements from a collection and converts them to String in HTML.
     */
    @Override
    public String generate(List<Employee> list) {
        StringBuilder sb = new StringBuilder()
                .append("<!DOCTYPE html>")
                .append("<html>")
                .append("<table>");
        for (Employee employee : list) {
            sb.append("<tr>")
                    .append("<td>")
                    .append(employee.getName())
                    .append("</td>")
                    .append("<td>")
                    .append(employee.getHired().toString())
                    .append("</td>")
                    .append("<td>")
                    .append(employee.getFired().toString())
                    .append("</td>")
                    .append("<td>")
                    .append(employee.getSalary())
                    .append("</td>")
                    .append("</tr>");
        }
        sb.append("</table>")
                .append("</html>");
        System.out.println("ITReport:");
        System.out.println(sb.toString());
        System.out.println();
        return sb.toString();
    }
}
