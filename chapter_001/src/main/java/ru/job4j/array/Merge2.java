package ru.job4j.array;

import java.util.Arrays;

public class Merge2 {
    public int[] merge(int[] left, int[] right) {
        int l = 0;
        int r = 0;
        int caunt = 0;
        int[] rsl = new int[left.length + right.length];
        int i = 0;
        while (i < (left.length + right.length)) {
            if ((r < right.length)&&(l < left.length)) {
                if (left[i - l] < right[i - r]) {
                    rsl[i] = left[i - l];
                    if ((r < right.length) ) {
                        r = r + 1;
                    } else {
                        // break;
                    }
                } else {
                    rsl[i] = right[i - r];
                    if ((l < left.length) && (i > 0)) {
                        l++;
                    } else {
                        // break;
                    }
                }
            } else if (!(r < right.length)&&((right.length + caunt) < left.length)) {
                rsl[i] = left[right.length + caunt];
                caunt++;
            } else if (!(l < left.length)&&((left.length + caunt) < right.length)) {
                rsl[i] = right[left.length + caunt];
                caunt++;
            } else {
                break;
            }
            i++;
        }
        return rsl;
    }

    public static void main(String[] args) {
        Merge2 process = new Merge2();
        int[] rsl = process.merge(
                new int[] {1, 3, 5},
                new int[] {2, 4}
        );
        System.out.println(Arrays.toString(rsl));
    }
}
