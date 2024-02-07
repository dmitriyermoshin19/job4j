package ru.job4j.sobes.javacor.algoritmi;

import java.util.Arrays;
import java.util.List;

public class BinarySearch {

    public static int binarySearch(int[] array, int target) {
        int[] sortArray = Arrays.stream(array).sorted().toArray();
        int left = 0;
        int right = sortArray.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (sortArray[mid] == target) {
                return mid;
            }

            if (sortArray[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // если элемент не найден
    }

    public static void main(String[] args) {
        int[] array = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int target = 23;
        int result = binarySearch(array, target);

        if (result == -1) {
            System.out.println("Элемент не найден");
        } else {
            System.out.println("Элемент найден по индексу " + result);
        }
    }

    public static int binarySearchInList(List<Integer> list, int target) {
      //  list.sort(Integer::compareTo);
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid) == target) {
                return mid;
            }

            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // если элемент не найден
    }
}
