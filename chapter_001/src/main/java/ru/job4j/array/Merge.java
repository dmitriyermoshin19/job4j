package ru.job4j.array;

import java.util.Arrays;

public class Merge {
    /**
     * Пробный.
     *
     * @param left
     * @param right
     * @return
     */
    public int[] merge(int[] left, int[] right) {
        int i = 0;
        int l = 0;
        int r = 0;
        int[] rsl = new int[left.length + right.length];

        while (i < (left.length + right.length)) {
            if (r < right.length && l < left.length) {
                if (left[l] < right[r]) {
                    rsl[i++] = left[l++];
                } else {
                    rsl[i++] = right[r++];
                }
            } else if (r == right.length) {
                rsl[i++] = left[l++];
            } else if (l == left.length) {
                rsl[i++] = right[r++];
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        Merge process = new Merge();
        int[] rsl = process.merge(
                new int[]{1, 3, 5},
                new int[]{2, 4}
        );
        System.out.println(Arrays.toString(rsl));
    }
}
