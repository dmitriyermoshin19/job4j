package ru.job4j.probnik;
import ru.job4j.array.Merge;

import java.util.Arrays;

public class Merge3 {
    /**
     * Окончательный.
     * @param left
     * @param right
     * @return
     */
    public int[] merge(int[] left, int[] right) {
        int resultPointer = 0;
        int leftPointer = 0;
        int rightPointer = 0;
        int[] result = new int[left.length + right.length];

        while (resultPointer < (left.length + right.length)) {
            if (leftPointer < left.length && rightPointer < right.length) {
                if (left[leftPointer] < right[rightPointer]) {
                    result[resultPointer++] = left[leftPointer++];
                } else {
                    result[resultPointer++] = right[rightPointer++];
                }
            } else if (leftPointer == left.length) {
                result[resultPointer++] = right[rightPointer++];
            } else if (rightPointer == right.length) {
                result[resultPointer++] = left[leftPointer++];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Merge3 process = new Merge3();
        int[] rsl = process.merge(
                new int[] {1, 3, 5},
                new int[] {2, 4}
        );
        System.out.println(Arrays.toString(rsl));
    }
}
