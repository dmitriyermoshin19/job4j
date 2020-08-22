package ru.job4j.oo4.tictactoo;

/**
 * enters data from the console
 */
public interface Input {

    String requestPrint(String request);

    int answerInt(String request);
}
