package ru.job4j.sobes.javacor.massiv;

import java.util.ArrayList;
import java.util.Arrays;

public class TwoArraysToOne {

    Integer[] twoArraysToOne(Integer[] a, Integer[] b) {
        Arrays.sort(a); // соритируем 1
        Arrays.sort(b);
        int i = 0; // курсор
        int c = 0;
        int m = 0; // мешок
        int max = 10; // капасити
        ArrayList<Integer> temp = new ArrayList<>(); // временное хранилише
        do {
            if(a[i]<b[c]) { // сравниваем значения 2
                m = m+a[i]; // добавляем в мешок 3
                if(m<max) { // сравниваем с капасити 4
                    temp.add(a[i]); // добавляем в общее хранилище 5
                    i++; // используем *курсор *вместо цикла для перебора   передвигаем курсор 6
                } else {
                    break;  // выходим из цикла 7
                }
            } else {
                m = m+b[c];
                if(m<max) {
                    temp.add(b[c]);
                    c++;
                } else {
                    break;
                }
            }
        } while(true);
        return temp.toArray(Integer[]::new);
    }

    public static void main(String[] args) {
        Integer[] m1 = {3,1};
        Integer[] m2 = {3,1,2,2,2,2,2,2};
        System.out.println(Arrays.toString(new TwoArraysToOne().twoArraysToOne(m1, m2)));


    }
}
