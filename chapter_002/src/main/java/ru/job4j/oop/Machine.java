package ru.job4j.oop;

import java.util.Arrays;

public class Machine {
    private final int[] coins = {10, 5, 2, 1};

    public int[] change(int money, int price) {
        int[] rsl = new int[100];
        int size = 0;
        int remains = money - price;
        for (int i = 0; i < coins.length; i++) {
            while (remains >= coins[i]) {
                remains = remains - coins[i];
                rsl[size++] = coins[i];
            }
            if (remains == 0) {
                break;
            }
        }
        return Arrays.copyOf(rsl, size);
    }
}
