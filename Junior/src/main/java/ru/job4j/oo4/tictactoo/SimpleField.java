package ru.job4j.oo4.tictactoo;

public class SimpleField implements Field {
    private final String[][] fld;
    /**
     * int size - размер поля.
     * 8 - для игры 3х3, 12 для игры 5х5.
     */
    public SimpleField(int size) {
        this.fld = new String[size][size];
    }

    @Override
    public String[][] getField() {
        createField();
        return fld;
    }

    @Override
    public void createField() {
        int numberX = 1;
        String tmp = " ";
        for (int x = 0; x < fld.length; x++) {
            int numberY = 1;
            if (x % 2 == 0) {
                for (int y = 0; y < fld.length; y++) {
                    if (x == 0 && y == 0) {
                        fld[x][y] = "y/x";
                    }
                    if (y == 0 && x != 0) {
                        fld[x][y] = " " + numberX++ + " ";
                    }
                    if (y % 2 == 0 && y != 0) {
                        fld[x][y] = tmp;
                    }
                    if (x == 0 && y % 2 == 0 && y != 0) {
                        fld[x][y] = String.valueOf(numberY++);
                    }
                    if ((y + 2) % 2 != 0) {
                        fld[x][y] = "  |  ";
                    }
                }
            }
            if ((x + 2) % 2 != 0) {
                for (int y = 0; y < fld.length; y++) {
                    fld[x][y] = "---";
                }
            }
        }
    }
}
