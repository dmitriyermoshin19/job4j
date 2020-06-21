package ru.job4j.oo4.srp;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.oo4.srp.report.*;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ReportEngineTest {
    MemStore memStore;
    Employee employee;
    List<Employee> list;

    @Before
    public void init() {
        memStore = new MemStore();
        LocalDate now = LocalDate.now();
        employee = new Employee("Ivan", now, now, 100);
        memStore.add(employee);
        list = memStore.findBy(employee -> employee.getSalary() != 0);
    }

    @Test
    public void whenDefaultReportGenerated() {
        DefaultReport defaultReport = new DefaultReport();
        String expect = "Name; Hired; Fired; Salary;"
                + System.lineSeparator()
                + employee.getName() + ";"
                + employee.getHired() + ";"
                + employee.getFired() + ";"
                + employee.getSalary() + ";"
                + System.lineSeparator();
        assertThat(defaultReport.generate(this.list), is(expect));
    }

    @Test
    public void whenITReportGenerated() {
        ITReport itReport = new ITReport();
        String expect = "<!DOCTYPE html>"
                + "<html>"
                + "<table>"
                + "<tr>"
                + "<td>"
                + employee.getName()
                + "</td>"
                + "<td>"
                + employee.getHired()
                + "</td>"
                + "<td>"
                + employee.getFired()
                + "</td>"
                + "<td>"
                + employee.getSalary()
                + "</td>"
                + "</tr>"
                + "</table>"
                + "</html>";
        assertThat(itReport.generate(this.list), is(expect));
    }

    @Test
    public void whenAccountantsReportGenerated() {
        AccountantsReport accountantsReport = new AccountantsReport();
        String expect = "Name; Hired; Fired; Salary;"
                + System.lineSeparator()
                + employee.getName() + ";"
                + employee.getHired() + ";"
                + employee.getFired() + ";"
                + String.format("%.2f руб", employee.getSalary()) + ";"
                + System.lineSeparator();
        assertThat(accountantsReport.generate(this.list), is(expect));
    }

    @Test
    public void whenHRReportGenerated() {
        HRReport hrReport = new HRReport();
        Employee worker2 = new Employee(
                "Igor", LocalDate.now(), LocalDate.now(), 200);
        memStore.add(worker2);
        list = memStore.findBy(em -> true);
        String expect = "Name; Salary;"
                + System.lineSeparator()
                + worker2.getName() + ";"
                + String.format("%.2f руб", worker2.getSalary()) + ";"
                + System.lineSeparator()
                + employee.getName() + ";"
                + String.format("%.2f руб", employee.getSalary()) + ";"
                + System.lineSeparator();

        assertThat(hrReport.generate(this.list), is(expect));
    }
    /* в идее проходит тест
    @Test
    public void whenMakeXMLReport() {
        XMLReport xmlReport = new XMLReport();
        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n"
                + "<Employees>\r\n"
                + "    <Employee>\r\n"
                + "        <name>Ivan</name>\r\n"
                + "        <hired>" + LocalDate.now() + "</hired>\r\n"
                + "    </Employee>\r\n"
                + "</Employees>\r\n";
        assertThat(xmlReport.generate(this.list), is(str));
    }*/

    @Test
    public void whenMakeJSONReport() {
        JSONReport jsonReport = new JSONReport();
        String expect = "{\"name\":\"Ivan\",\"hired\":"
                + "{\"year\":" + LocalDate.now().getYear() + ","
                + "\"month\":" + LocalDate.now().getMonthValue() + ","
                + "\"day\":" + LocalDate.now().getDayOfMonth() + "},"
                + "\"fired\":"
                + "{\"year\":" + LocalDate.now().getYear() + ","
                + "\"month\":" + LocalDate.now().getMonthValue() + ","
                + "\"day\":" + LocalDate.now().getDayOfMonth() + "},"
                + "\"salary\":100.0}";
        assertThat(jsonReport.generate(this.list), is(expect));
    }
}
