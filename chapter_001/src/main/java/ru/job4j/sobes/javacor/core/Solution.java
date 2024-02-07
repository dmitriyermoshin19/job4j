package ru.job4j.sobes.javacor.core;

import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    static class Person {
        String name;

        public Person(String name) {
            this.name = name;
        }
        public static void changeName(Person person) {
            person.name = "Alice";
        }
    }
    public static void main(String[] args) {
        Integer a = 0;
        int b = 0;
        AtomicInteger c = new AtomicInteger(0);
        String d = "0";

        increment(a);
        increment(b);
        increment(c);
        increment(d);
        System.out.println(a);// 0
        System.out.println(b);// 0
        System.out.println(c);// 1
        System.out.println(d);// 0

        Person person = new Person("Bob");
        Person.changeName(person);// принимает ту же ссылку, что в мейне и меняет, т.к. не имутебл как String
        System.out.println(person.name); // Выведет "Alice"
    }
    public static void increment(Integer a) {
        ++a; // старая ссылка в методе уничтожается, потому что Integer неизменяемый как и String
    }
    public static void increment(int b) {
        ++b;
    }
    public static void increment(AtomicInteger c) {
        c.incrementAndGet();
    }
    public static void increment(String d) {
        d = String.valueOf(Integer.parseInt(d) + 1);
    }

}
