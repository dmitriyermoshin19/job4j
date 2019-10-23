package ru.job4j.array;

public class CheckSort {
    public static boolean check1(int[] date) {
        boolean result = true;
        for (int i = 0; i < date.length - 1; i++) {
            if (!(date[i] < date[i + 1])) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
            int[] input = {1, 2, 3, 4, 5};
            boolean check = check1(input);
            System.out.println("metod otsortirovan - " + check);
    }
}
