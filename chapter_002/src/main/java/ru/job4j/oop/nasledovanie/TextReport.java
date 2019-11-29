package ru.job4j.oop.nasledovanie;

public class TextReport {

    public String generate(String name, String body) {
        return name + System.lineSeparator() + body;
    }
}
