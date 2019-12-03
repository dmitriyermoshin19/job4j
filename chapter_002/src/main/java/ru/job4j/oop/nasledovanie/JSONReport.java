package ru.job4j.oop.nasledovanie;

public class JSONReport extends TextReport {
    @Override
    public String generate(String name, String body) {
        return name + ":" + name + System.lineSeparator() + body + ":" + body;
    }
}
