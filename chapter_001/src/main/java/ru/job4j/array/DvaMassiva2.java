package ru.job4j.array;

public class DvaMassiva2 {
    public static void main(String[] args) {
        int[] a = {8, 4, 1, 0, 3};
        int[] b = {1, 2, 5, 9, 4, 0};
        for (int i = 0; i < a.length; i++) {
            for (int i1 = 0; i1 < b.length; i1++) {
                if (a[i] == b[i1]) {
                    System.out.println(a[i]);
                    break;
                }
            }
        }
    }
}
