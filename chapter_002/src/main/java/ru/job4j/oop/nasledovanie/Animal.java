package ru.job4j.oop.nasledovanie;

public class Animal {
    private String name;

    public Animal(String x) {
        this.name = x;
        System.out.println(x);
    }

    public static void main(String[] args) {
        Animal animal = new Animal("load Animal");
        Predator predator = new Predator("load Predator");
        Tiger tiger = new Tiger("load Tiger");
    }
}
