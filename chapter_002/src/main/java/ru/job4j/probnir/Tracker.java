package ru.job4j.probnir;
import java.util.Arrays;

public class Tracker {
    /**
     * Пробный.
     * @param left
     * @param right
     * @return
     */
    public int[] merge(int[] left, int[] right) {
        int l = 0;
        int r = 0;
        int count = 0;
        int[] rsl = new int[left.length + right.length];
        int i = 0;
        while (i < (left.length + right.length)) {
            if (r < right.length && l < left.length) {
                if (left[i - l] < right[i - r]) {
                    rsl[i] = left[i - l];
                    r++;
                } else {
                    rsl[i] = right[i - r];
                    l++;
                }
            } else if (r == right.length) {
                rsl[i] = right[right.length - 1];
                r++;
            } else if (l == left.length) {
                rsl[i] = left[left.length - 1];
                r++;
            } else if (!(r < right.length) && ((right.length + count) < left.length)) {
                rsl[i] = left[right.length + count];
                count++;
            } else if (!(l < left.length) && ((left.length + count) < right.length)) {
                rsl[i] = right[left.length + count];
                count++;
            } else {
                break;
            }
            i++;
        }
        return rsl;
    }

    public static void main(String[] args) {
        Tracker process = new Tracker();
        int[] rsl = process.merge(
                new int[] {1, 3, 5},
                new int[] {2, 4}
        );
        System.out.println(Arrays.toString(rsl));
    }
}

