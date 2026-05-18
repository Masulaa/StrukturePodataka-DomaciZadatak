package Domaci;

public class Move {
    int row;
    int col;
    boolean wasSafe;

    public Move(int row, int col, boolean wasSafe) {
        this.row = row;
        this.col = col;
        this.wasSafe = wasSafe;
    }
}