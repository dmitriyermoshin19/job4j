package ru.job4j.lambda;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Calculator {
    public void multiple(int start, int finish, int value,
                         BiFunction<Integer, Integer, Double> op,
                         Consumer<Double> media) {
        for (int index = start; index != finish; index++) {
            media.accept(op.apply(value, index));
        }
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.multiple(
                0, 10, 2,
                (f, k) -> {
                    double result = f * k;
                    System.out.printf("Multiple %s * %s = %s %n", f, k, result);
                    return result;
                },
                result -> System.out.println(result)
        );
    }
}
