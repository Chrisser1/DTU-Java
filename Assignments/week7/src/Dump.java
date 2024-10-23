public class Dump {
    private int[][] square;

    public Dump() {
        this.square = new int[1][1];
    }

    public void update(boolean addTwo) {
        int currentSize = this.square.length;
        int newSize = currentSize + 1;
        int[][] newSquare = new int[newSize][newSize];

        int incrementValue = addTwo ? 2 : 1;

        // Update the values based on the addTwo boolean
        for (int i = 0; i < currentSize; i++) {
            for (int j = 0; j < currentSize; j++) {
                newSquare[i][j] = incrementValue + this.square[i][j];
            }
        }

        this.square = newSquare;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (int[] values : square) {
            for (int value : values) {
                out.append(value);
            }
            out.append("\n");
        }
        return out.toString();
    }
}
