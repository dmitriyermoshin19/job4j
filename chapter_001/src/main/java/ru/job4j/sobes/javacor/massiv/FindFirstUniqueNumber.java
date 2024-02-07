package ru.job4j.sobes.javacor.massiv;

import java.util.HashMap;

public class FindFirstUniqueNumber {
    /**
     * найти первое неповторяющееся число
     */
    static int get(int[] mas) {
        int n = -1;
        for(int i = 0;i < mas.length;i++) {
            n = mas[i]; // берем первое число из массива
            for(int c = i+1;c < mas.length;c++) { // берем все последующие
                int m = mas[c];
                if(n == m) {  // сравниваем их с первым
                    break; //выход из цикла
                }
                if (c == mas.length-1) { // проверяем прохождение всего массива
                    return n;
                }
            }
        }
        return n;
    }

    public static int get1(int[] nums) {
        // Создаем HashMap для подсчета частоты встречаемости чисел
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        // Считаем частоту встречаемости чисел в массиве
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Ищем первое число с частотой встречаемости равной 1
        for (int num : nums) {
            if (frequencyMap.get(num) == 1) {
                return num;
            }
        }

        // Возвращаем -1, если такого числа не найдено
        return -1;
    }

    public static void main(String[] args) {
        int[] mas1 = new int[]{3,4,9,4,3,8,3};
        int[] mas = new int[]{5,3,4};
        System.out.println(get1(mas1));
    }

}

