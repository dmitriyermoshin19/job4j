package ru.job4j.sobes.javacor.massiv;

import java.util.Arrays;

public class SortPuzirek {

    public static void main(String[] args) {
/*        int[] mas1 = new int[]{3,4,9,4,3,8,3};
        int[] mas = new int[]{5,3,4};
        System.out.println(get(mas1));*/

        /**
         * сортировка пузырьком
         */
        int[] mas = {11, 3, 14, 16, 7};
        boolean isSorted = false;
        int buf;
        while (!isSorted) {
            isSorted = true;
            System.out.println(Arrays.toString(mas));
            for (int i = 0; i < mas.length - 1; i++) {
                if (mas[i] > mas[i + 1]) {
                    isSorted = false;
                    buf = mas[i];
                    mas[i] = mas[i + 1];
                    mas[i + 1] = buf;
                }
            }
        }
        System.out.println(Arrays.toString(mas));
    }
}
