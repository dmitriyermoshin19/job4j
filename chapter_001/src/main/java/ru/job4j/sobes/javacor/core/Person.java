package ru.job4j.sobes.javacor.core;

public class Person {
    private static int id;

    public static Person of() {
        Person p = new Person();
        id++;
        return p;
    }

    public int getPersonId() {
        return id;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Person.of().getPersonId());
        }
    }
}

class Person1 {
    private static int id;

    public Person1() {
        id++;
    }

    public int getPersonId() {
        return id;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(new Person1().getPersonId());
        }
    }
}