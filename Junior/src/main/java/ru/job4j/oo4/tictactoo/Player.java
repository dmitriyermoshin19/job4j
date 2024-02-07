package ru.job4j.oo4.tictactoo;

public interface Player {
    int[] getMotion(Input input, int size);

    String getSymbol();
}
