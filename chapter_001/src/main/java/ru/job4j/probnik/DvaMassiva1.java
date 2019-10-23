package ru.job4j.probnik;

public class DvaMassiva1 {
    public static void main(String[] args) {
        int[] a = {8, 4, 1, 0, 3};
        int[] b = {1, 2, 5, 9, 4, 0};
        int[] chisla = new int[3];
        for (int i = 0; i < a.length; i++) {
            for (int i1 = 0; i1 < b.length; i1++) {
                if (a[i] == b[i1]) {
                    for (int i2 = 0; i2 < chisla.length; i2++) {
                        chisla[i2] = a[i];
                        System.out.println(chisla[i2]);
                        break;
                    }
                }
            }
        }
    }
}
