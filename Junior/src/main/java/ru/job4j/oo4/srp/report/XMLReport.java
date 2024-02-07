package ru.job4j.oo4.srp.report;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import ru.job4j.oo4.srp.Employee;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class XMLReport implements ReportEngine {
//  проще здесь oo3\sqlite\createxml\StoreXML.java
    /**
     * The method retrieves elements from a collection and converts them to String in XML.
     */
    @Override
    public String generate(List<Employee> list) {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        String str = "";
        try {
            builder = builderFactory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElement("Employees");
            document.appendChild(root);
            for (Employee emp : list) {
                Element employee = document.createElement("Employee");
                root.appendChild(employee);
                Element empData = document.createElement("name");//создаем поле name
                empData.appendChild(document.createTextNode(emp.getName()));//инициализируем
                employee.appendChild(empData);//добавляем в Element
                empData = document.createElement("hired");
                empData.appendChild(document.createTextNode(emp.getHired().toString()));
                employee.appendChild(empData);
            }
            StringWriter writer = new StringWriter();
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(writer);
            transformer.transform(source, result);
            str = writer.getBuffer().toString();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        System.out.println("XMLReport:");
        System.out.println("" + str);
        return str;
    }

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2022, 1, 1);
        Employee employee = new Employee("Вася", date);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        XMLReport xmlReport = new XMLReport();
        String st = xmlReport.generate(employees);
        String fileName = "Junior/src/main/java/ru/job4j/oo4/srp/report.xml";
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(st);
        } catch (IOException e) {
            e.printStackTrace();
        }

        File f = new File("Junior/src/main/java/ru/job4j/oo4/srp/test.zip");
        try (ZipOutputStream out = new ZipOutputStream(new FileOutputStream(f))) {
            ZipEntry e = new ZipEntry("mytext.txt");
            out.putNextEntry(e);
            byte[] data = st.getBytes();
            out.write(data, 0, data.length);;
        } catch (IOException e) {
            e.printStackTrace();
        }

        File f1 = new File("Junior/src/main/java/ru/job4j/oo4/srp/test1.zip");
        try (ZipOutputStream out = new ZipOutputStream(new FileOutputStream(f1))) {
            ZipEntry zipEntry = new ZipEntry("reportName" + ".xml");
            out.putNextEntry(zipEntry);
            out.write(st.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
