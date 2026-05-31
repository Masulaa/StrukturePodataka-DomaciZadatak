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

        int size = board.getSize();

        while (true) {

            int r = random.nextInt(size);
            int c = random.nextInt(size);

            Cell cell = board.getCell(r, c);

            if (cell.getState() == CellState.HIDDEN) {

                board.revealCell(r, c);

                boolean wasSafe = !cell.isMine();

                moveHistory.insert(
                    new Move(r, c, wasSafe)
                );

                return board.getGameState();
            }
        }
    }

    public MyLinkedList getMoveHistory() {
        return moveHistory;
    }

}