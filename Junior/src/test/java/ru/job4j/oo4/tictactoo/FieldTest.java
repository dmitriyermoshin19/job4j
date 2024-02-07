package ru.job4j.oo4.tictactoo;


import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FieldTest {

    @Test
    public void getField() {
        Field fieldTest = new FieldTst();
        String[][] field = fieldTest.getField();
        assertThat(field[0][0], is("1"));
    }

    private static class FieldTst implements Field {

        @Override
        public String[][] getField() {
            String[][] fld = new String[1][1];
            fld[0][0] = "1";
            return fld;
        }

        @Override
        public void createField() {

        }
    }
}