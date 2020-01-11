package ru.job4j.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Matrix {
    public static List<Integer> matrixArraysToList(Integer[][] matrix) {
        return Stream.of(matrix).flatMap(row -> Arrays.stream(row))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Integer[][] matrix = {
                new Integer[] {10, 20},
                new Integer[] {30, 40}
        };
        List<Integer> result = matrixArraysToList(matrix);
        result.forEach(integer -> System.out.print(integer + " "));
    }
}
