package ru.job4j.oo4.tictactoo;

public class StartGame {

    /**
     * Coordinates of the motion .
     */
    private int x;
    private int y;
    /**
     * passing a motion to the player according to player Symbol.
     */
    private String passMotion;

    private final Player player1;
    private final Player player2;
    private final int sizeField;
    private final String[][] field;
    private final GameLogic gameLogic;

    public StartGame(Player player1, Player player2,
                     String passMotion, int sizeField) {
        this.player1 = player1;
        this.player2 = player2;
        this.passMotion = passMotion;
        this.sizeField = sizeField;
        this.field = new SimpleField(sizeField).getField();
        this.gameLogic = new GameLogic(field);
    }

    /**
     * checks the entered coordinates and the cell by coordinates.
     * координаты умножаем на 2, потомучто клетки для хода записаны через ячейки для графики
     */
    private boolean validation(int[] motion) {
        boolean rst = false;
        this.x = motion[1] * 2;
        this.y = motion[0] * 2;
        if (motion[0] < 0 || motion[1] < 0
                || motion[0] > sizeField / 2 - 1 || motion[1] > sizeField / 2 - 1
                || !field[this.x][this.y].equals(" ")) {
            System.out.println("Введите корректные координаты пустой клетки: > 0 и <= "
                    + (sizeField / 2 - 1));
            rst = true;
        }
        return rst;
    }

    /**
     * gets a motion from the player who should be to move
     * and sends the motion for validation until it gets a correct response.
     */
    private void motionOfPlayers(Input input) {
        int[] motion;
        if (passMotion.equals(player1.getSymbol())) {
            do {
                motion = player1.getMotion(input, sizeField);
            } while (validation(motion));
        } else if (passMotion.equals(player2.getSymbol())) {
            do {
                motion = player2.getMotion(input, sizeField);
            } while (validation(motion));

        }
    }

    /**
     * writes X or O according to the coordinates of the motion in the cell of field
     * and passes the motion to another player.
     */
    private void saveMotion() {
        String constX = "x";
        String const0 = "o";
        if (passMotion.equals(constX)) {
            field[x][y] = "X";
        } else if (passMotion.equals(const0)) {
            field[x][y] = "O";
        }
        if (passMotion.equals(player1.getSymbol())) {
            passMotion = player2.getSymbol();
        } else {
            passMotion = player1.getSymbol();
        }
    }

    /**
     * launches the game.
     */
    public void start(Input input, PrintField printField) {
        System.out.println("==Добро пожаловать в игру==");
        System.out.println("   =Крестики - Нолики!=");
        while (true) {
            printField.print(field);
            motionOfPlayers(input);
            saveMotion();
            if (this.gameLogic.checkWinner() || !this.gameLogic.hasGap()) {
                printField.print(field);
                break;
            }
        }
    }

    public static void main(String[] args) {
        new StartGame(new Human("Sergey", "x"),
                new Robot("Julia", "o"),
                "o",
                12)
                .start(new ConsoleInput(), new PrintToConsole());
    }
}
