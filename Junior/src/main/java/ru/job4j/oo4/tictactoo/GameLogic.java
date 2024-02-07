package ru.job4j.oo4.tictactoo;

public class GameLogic {
    private final String[][] field;

    public GameLogic(String[][] field) {
        this.field = field;
    }

    /**
     * checks the existence of X or O in the sequence from the starting point
     * to the last one via Delta according to the field length
     * on vertically, horizontally and diagonally.
     */
    public boolean fillBy(String sym, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.field.length / 2 - 1; index++) {
            if (!this.field[startX][startY].equals(sym)) {
                result = false;
                break;
            }
            startX += deltaX;
            startY += deltaY;
        }
        return result;
    }

    /**
     * substitutes the starting point and Delta in fillBy for checking the win.
     */
    public boolean win(String sym) {
        boolean result = false;
        for (int i = 2; i < this.field.length; i++) {
            if (this.fillBy(sym, i, 2, 0, 2)
                    || this.fillBy(sym, 2, i, 2, 0)) {
                result = true;
                break;
            }
        }
        return  result || this.fillBy(sym, 2, 2, 2, 2)
                || this.fillBy(sym, this.field.length - 2, 2, -2, 2);
    }

    boolean checkWinner() {
        boolean result = false;
        if (this.win("X")) {
            System.out.println("Победили Крестики!");
            result = true;
        } else if (this.win("O")) {
            System.out.println("Победили Нолики!");
            result = true;
        }
        return result;
    }

    /**
     * checks for empty cells in the field.
     */
    public boolean hasGap() {
        boolean result = false;
        for (int x = 2; x < field.length; x += 2) {
            for (int y = 2; y < field.length; y += 2) {
                if (field[x][y].equals(" ")) {
                    result = true;
                    break;
                }
            }
        }
        if (!result) {
            System.out.println("Ничья! Победила Дружба!");
        }
        return result;
    }
}
