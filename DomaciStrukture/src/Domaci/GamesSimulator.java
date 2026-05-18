package Domaci;

public class GamesSimulator {

    public static Player createBot(Board board) {
        return new Player(board);
    }
}