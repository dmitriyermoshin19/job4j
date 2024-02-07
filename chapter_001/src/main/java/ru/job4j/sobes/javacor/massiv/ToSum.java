package ru.job4j.sobes.javacor.massiv;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ToSum {
    /**
     * Есть массив целых чисел и число K.
     * Найти индексы двух таких (не обязательно различных) чисел в массиве,
     * сумма которых равна K
     * Input: nums = [2,7,11,15], K = 13
     * Output: [0,2]
     */
    public static int[] twoSum(int[] numbers, int target) {
        for (int i =0; i < numbers.length; i++) {
            for (int c = i+1; c< numbers.length; c++) {
                if (numbers[i] + numbers[c] == target) {
                    return  new int[] {i, c};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] r = ToSum.twoSum1(new int[] {2,7,11,15}, 13);
        System.out.println(Arrays.toString(r));
    }

    public static int[] twoSum1(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();//значение и номер ячейки - 1 элемент

        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i]; // 2 element
            if (map.containsKey(complement)) {
                result[0] = map.get(complement);
                result[1] = i;
                break;
            }
            map.put(numbers[i], i);
        }

        return result;
    }
}
