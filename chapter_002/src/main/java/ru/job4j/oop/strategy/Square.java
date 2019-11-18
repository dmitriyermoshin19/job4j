package ru.job4j.oop.strategy;

public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append(" +++++" + System.lineSeparator());
        pic.append("+     +" + System.lineSeparator());
        pic.append("+     +" + System.lineSeparator());
        pic.append(" +++++");
        return pic.toString();
    }
}
