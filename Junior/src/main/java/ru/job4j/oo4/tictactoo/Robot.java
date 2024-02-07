package ru.job4j.oo4.tictactoo;

import java.util.Random;

public class Robot implements Player {
    private final String name;
    private final String symbol;
    private final int[] motion = new int[2];
    private final Random random = new Random();

    public Robot(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }

    @Override
    public int[] getMotion(Input input, int size) {
        System.out.println("Сейчас ходит робот " + name);
        if (size == 8) {
            size = 4;
        } else if (size == 12) {
            size = 6;
        }
        this.motion[0] = random.nextInt(size);
        this.motion[1] = random.nextInt(size);
        return this.motion;
    }
}
