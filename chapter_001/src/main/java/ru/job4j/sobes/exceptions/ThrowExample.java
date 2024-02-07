package ru.job4j.sobes.exceptions;

import java.io.IOException;

public class ThrowExample {

    void willThrow() throws IOException {
        throw new IOException("Because I Can!"); //строка не выводится сама по себе в консоль
    }

    void doSomething() {
        System.out.println("Doing something");
        try {
            willThrow();
        } catch (IOException e) {
            System.out.println("IOException was successfully handled: " + e);
        }
    }

    public static void main(String[] args) {
        ThrowExample throwExample = new ThrowExample();
        throwExample.doSomething();
        int[] array = new int[3];
        //array[5] = 12;
        try {
            array[5] = 12;
        } catch (RuntimeException e) { //ловит непроверяемую ошибку: Process finished with exit code 0
            System.out.println("ловит непроверяемую RuntimeException ошибку: " + e);
        }
    }
}
