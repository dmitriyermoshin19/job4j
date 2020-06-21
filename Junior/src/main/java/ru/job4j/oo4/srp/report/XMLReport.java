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
import java.io.StringWriter;
import java.util.List;

public class XMLReport implements ReportEngine {

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
                Element empData = document.createElement("name");
                empData.appendChild(document.createTextNode(emp.getName()));
                employee.appendChild(empData);
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
}
