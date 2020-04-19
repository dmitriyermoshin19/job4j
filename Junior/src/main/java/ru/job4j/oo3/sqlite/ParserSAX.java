package ru.job4j.oo3.sqlite;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class ParserSAX {
    private int sum;

    private class Handler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("entry")) {
                String value = attributes.getValue("field");
                sum += Integer.parseInt(value);
            }
        }
    }

    /**
     * метод парсит XML файл.
     *
     * @param file - XML файл для парсинга.
     * @return выводит арифметическую сумму значений всех атрибутов field
     */
    public int parseFile(File file) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        Handler handler = new Handler();
        SAXParser parser;
        try {
            parser = factory.newSAXParser();
            parser.parse(new File(file.getPath()), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.sum;
    }
}
