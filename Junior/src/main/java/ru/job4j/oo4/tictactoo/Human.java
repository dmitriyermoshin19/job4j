package ru.job4j.oo4.tictactoo;

public class Human implements Player {
    private final String name;
    private final String symbol;
    private final int[] motion = new int[2];

    public Human(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public int[] getMotion(Input input, int size) {
        System.out.println("Сейчас ходит " + this.name);
        if (size == 8) {
            size = 3;
        } else if (size == 12) {
            size = 5;
        }
        this.motion[0] = input.answerInt("Введите координату x " + "(до " + size + ")" + ": ");
        this.motion[1] = input.answerInt("Введите координату y " + "(до " + size + ")" + ": ");
        return this.motion;
    }
}
