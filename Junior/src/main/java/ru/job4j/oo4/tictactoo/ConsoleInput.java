package ru.job4j.oo4.tictactoo;

import java.util.Scanner;
import org.apache.commons.lang3.math.NumberUtils;

public class ConsoleInput implements Input {
    private final Scanner scanner = new Scanner(System.in);

    /**
     * prints a request to the console and receives an answer from the console
     */
    @Override
    public String requestPrint(String request) {
        System.out.println(request);
        return scanner.nextLine();
    }

    /**
     * checks if the answer matches a number and parse it to int
     */
    @Override
    public int answerInt(String request) {
        int answer = -1;
        String tmp = requestPrint(request);
        if (NumberUtils.isParsable(tmp)) {
            answer = Integer.parseInt(tmp);
        }
        return answer;
    }
}
