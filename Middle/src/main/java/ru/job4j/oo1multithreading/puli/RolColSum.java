package ru.job4j.oo1multithreading.puli;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class RolColSum {

    public static class Sums {
        int rowSum;
        int colSum;

        public Sums(int rowSum, int colSum) {
            this.rowSum = rowSum;
            this.colSum = colSum;
        }
    }

    /**
     * Возвращает массив колонки по ее номеру i.
     */
    private static int[] getColumn(int[][] matrix, int i) {
        return Arrays.stream(matrix)
                .mapToInt(values -> values[i])
                .toArray();
    }

    /**
     * Считает сумму чисел в массиве
     */
    private static int getArraySum(int[] array) {
        return Arrays.stream(array).sum();
    }

    /**
     * Последовательный код. Считает сумму в столбце и строке,
     * записывает сумму элементов по i строке и i столбцу в класс Sums;
     * */
    public static Sums[] sum(int[][] matrix) {
        Sums[] result = new Sums[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            int[] col = getColumn(matrix, i);
            result[i] = new Sums(getArraySum(row), getArraySum(col));
        }
        return result;
    }

    /**
     * Параллельный код. Считает сумму в столбце и строке параллельно,
     * записывает сумму элементов по i строке и i столбцу в класс Sums;
     * */
    public static Sums[] asyncSum(int[][] matrix) throws ExecutionException, InterruptedException {
        Sums[] result = new Sums[matrix.length];
        Map<Integer, CompletableFuture<Sums>> futures = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            futures.put(i, getTask(matrix, i));
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = futures.get(i).get();
        }
        return result;
    }

    private static CompletableFuture<Sums> getTask(int[][] matrix, int i) {
        return CompletableFuture.supplyAsync(() -> {
            int[] row = matrix[i];
            int[] col = getColumn(matrix, i);
            return new Sums(getArraySum(row), getArraySum(col));
        });
    }
}
