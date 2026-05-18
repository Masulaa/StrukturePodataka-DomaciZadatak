package Domaci;
import java.util.Random;

public class Board {

    private Cell[][] grid;
    private int size;
    private int numMines;

    public Board(int size, int numMines) {
        if (size <= 0 || numMines < 0 || numMines >= size * size) {
            throw new IllegalArgumentException();
        }

        this.size = size;
        this.numMines = numMines;
        this.grid = new Cell[size][size];

        initializeGrid();
        placeMines();
        calculateAdjacentMines();
    }
    
    

    private void initializeGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new Cell();
            }
        }
    }

    private void placeMines() {
        Random rand = new Random();
        int placed = 0;

        while (placed < numMines) {
            int r = rand.nextInt(size);
            int c = rand.nextInt(size);

            if (!grid[r][c].isMine()) {
                grid[r][c].setMine(true);
                placed++;
            }
        }
    }

    private void calculateAdjacentMines() {
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (grid[i][j].isMine()) continue;

                int count = 0;

                for (int k = 0; k < 8; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx >= 0 && ny >= 0 && nx < size && ny < size) {
                        if (grid[nx][ny].isMine()) {
                            count++;
                        }
                    }
                }

                grid[i][j].setAdjacentMines(count);
            }
        }
    }
    
    

    public void revealCell(int row, int col) {
        if (grid[row][col].getState() == CellState.REVEALED) return;

        CoordinateQueue queue = new CoordinateQueue();
        queue.enqueue(row, col);

        while (!queue.isEmpty()) {
            int[] coords = queue.dequeue();
            int r = coords[0];
            int c = coords[1];

            Cell current = grid[r][c];

            if (current.getState() == CellState.REVEALED) continue;

            current.setState(CellState.REVEALED);

            if (current.getAdjacentMines() == 0 && !current.isMine()) {

                int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
                int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

                for (int k = 0; k < 8; k++) {
                    int nx = r + dx[k];
                    int ny = c + dy[k];

                    if (nx >= 0 && ny >= 0 && nx < size && ny < size) {
                        if (grid[nx][ny].getState() == CellState.HIDDEN) {
                            queue.enqueue(nx, ny);
                        }
                    }
                }
            }
        }
    }

    public GameOutcome getGameState() {

        boolean allSafeRevealed = true;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                Cell cell = grid[i][j];

                if (cell.isMine() && cell.getState() == CellState.REVEALED) {
                    return GameOutcome.DEFEAT;
                }

                if (!cell.isMine() && cell.getState() != CellState.REVEALED) {
                    allSafeRevealed = false;
                }
            }
        }

        if (allSafeRevealed) return GameOutcome.VICTORY;

        return GameOutcome.IN_PROGRESS;
    }
}