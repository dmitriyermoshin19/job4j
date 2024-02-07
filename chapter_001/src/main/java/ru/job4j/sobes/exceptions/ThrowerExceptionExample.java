package ru.job4j.sobes.exceptions;

import java.io.IOException;
import java.util.Random;

/**
 * Пример, в котором показываются две опции — когда находится обработчик для исключения и когда нет.
 */

public class ThrowerExceptionExample {

    /**
     * Здесь две опции: или бросается {@link IOException} или {@link IllegalAccessException}.
     * Выбирается случайным образом.
     */
    private String randomThrower() throws IOException, IllegalAccessException {
        if (new Random().nextBoolean()) {
            throw new IOException();
        } else {
            throw new IllegalAccessException("Yes - caught IllegalAccessException - Process finished with exit code 1");
        }
    }

    /**
     * Здесь происходит перехват одного из возможных исключений — {@link IOException}.
     * А вот второй будет пробрасываться дальше вверх по вызову.
     */
    private String populateString() throws IllegalAccessException { //Process finished with exit code 1
        try {
            return randomThrower();
        } catch (IOException e) {   //Process finished with exit code 0
            return "Caught IOException";
        }
    }

    public static void main(String[] args) throws IllegalAccessException {
        ThrowerExceptionExample example = new ThrowerExceptionExample();
        System.out.println(example.populateString());
    }
}
