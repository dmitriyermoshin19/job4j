package ru.job4j.oo4.tictactoo;

public class PrintToConsole implements PrintField {
    @Override
    public void print(String[][] fld) {
        for (String[] strings : fld) {
            for (int y = 0; y < fld.length; y++) {
                if (y > fld.length - 2) {
                    System.out.println(strings[y]);
                    break;
                }
                System.out.print(strings[y]);
            }
        }
    }
}
