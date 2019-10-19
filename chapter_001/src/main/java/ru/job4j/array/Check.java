package ru.job4j.array;

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int index = 0; data.length != index; index++) {
            if (data[index] != data[0]) {
                 result = false;
                break;
            }
        }
        return result;
    }
}
