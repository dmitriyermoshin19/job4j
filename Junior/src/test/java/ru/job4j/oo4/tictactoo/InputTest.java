package ru.job4j.oo4.tictactoo;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class InputTest {

    @Test
    public void testRequestPrint() {
        Input inputTst = new InputTst();
        String request = "request";
        String answer = inputTst.requestPrint(request);
        assertThat(answer, is("answer"));
    }

    private static class InputTst implements Input {
        @Override
        public String requestPrint(String request) {
            return "answer";
        }

        @Override
        public int answerInt(String request) {
            return 0;
        }
    }
}