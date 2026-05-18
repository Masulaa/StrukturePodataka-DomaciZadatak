package Domaci;

import java.util.Random;

public class Player {

    private MyLinkedList moveHistory;
    private Board board;
    private Random random;

    public Player(Board board) {
        this.board = board;
        this.moveHistory = new MyLinkedList();
        this.random = new Random();
    }

    public GameOutcome playTurn() {

        int size = getBoardSize();

        while (true) {
            int r = random.nextInt(size);
            int c = random.nextInt(size);

            // pokušava dok ne nađe HIDDEN polje
            try {
                Cell cell = getCell(r, c);
                if (cell.getState() == CellState.HIDDEN) {

                    board.revealCell(r, c);

                    boolean wasSafe = !cell.isMine();
                    moveHistory.insert(new Move(r, c, wasSafe));

                    return board.getGameState();
                }
            } catch (Exception ignored) {}
        }
    }

    public MyLinkedList getMoveHistory() {
        return moveHistory;
    }

    // pomoćne metode (jer je grid private u Board)
    private Cell getCell(int r, int c) throws Exception {
        java.lang.reflect.Field gridField = Board.class.getDeclaredField("grid");
        gridField.setAccessible(true);
        Cell[][] grid = (Cell[][]) gridField.get(board);
        return grid[r][c];
    }

    private int getBoardSize() {
        try {
            java.lang.reflect.Field sizeField = Board.class.getDeclaredField("size");
            sizeField.setAccessible(true);
            return (int) sizeField.get(board);
        } catch (Exception e) {
            return 0;
        }
    }
}