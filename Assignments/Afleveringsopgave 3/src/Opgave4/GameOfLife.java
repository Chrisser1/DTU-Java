package Opgave4;

public class GameOfLife {
    int[][] gameState;

    public GameOfLife(int n) {
        this.gameState = new int[n][n];
    }

    public GameOfLife(int[][] initialState) {
        this.gameState = initialState;
    }

    public void nextState() {
        int lengthX = this.gameState.length;
        int lengthY = this.gameState[0].length;
        int[][] newGameState = new int[lengthX][lengthY]; // Temporary array for the next state

        for (int x = 0; x < lengthX; x++) {
            for (int y = 0; y < lengthY; y++) {
                int neighbors = liveNeighbors(x, y);

                if (this.gameState[x][y] == 1) {
                    // Cell is alive
                    if (neighbors < 2 || neighbors > 3) {
                        // Cell dies due to underpopulation or overpopulation
                        newGameState[x][y] = 0;
                    } else {
                        // Cell survives
                        newGameState[x][y] = 1;
                    }
                } else {
                    // Cell is dead
                    if (neighbors == 3) {
                        // Cell becomes alive due to reproduction
                        newGameState[x][y] = 1;
                    } else {
                        // Cell remains dead
                        newGameState[x][y] = 0;
                    }
                }
            }
        }

        // Update the gameState with the new state
        this.gameState = newGameState;
    }

    private int liveNeighbors(int x, int y) {
        int count = 0;
        int lengthX = this.gameState.length;
        int lengthY = this.gameState[0].length;

        // Loop through all possible neighbors
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                // Skip the cell itself (0,0)
                if (i == 0 && j == 0) {
                    continue;
                }

                int neighborX = x + i;
                int neighborY = y + j;

                // Check if the neighbor is within bounds
                if (neighborX >= 0 && neighborX < lengthX && neighborY >= 0 && neighborY < lengthY) {
                    // If the cell is more than one then there is a neighbor
                    count += gameState[neighborX][neighborY] > 0 ? 1 : 0;
                }
            }
        }

        return count;
    }
}
