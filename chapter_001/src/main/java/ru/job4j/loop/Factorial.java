package ru.job4j.loop;

public class Factorial {
    public int calc(int n) {
        int result = 1;
        for (int index = 1; index <= n; index++) {
            result = result * index;
        }
        return result;
    }
}
