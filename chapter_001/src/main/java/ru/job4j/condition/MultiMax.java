package ru.job4j.condition;

public class MultiMax {
    public int max(int first, int second, int third) {
        int result1 = first>second? first:second;
        int result = result1>third? result1:third;

        return result;
    }
}
