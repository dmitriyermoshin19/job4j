package ru.job4j.oop.strategy;

public class Paint {
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
    public static void main(String[] args) {
        Shape shape = new Square();
        new Paint().draw(shape);
        new Paint().draw(new Triangle());
    }
}
