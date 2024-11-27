public class DumpSkeleton {
    private int[] line;

    public DumpSkeleton(int size) {
        if (size < 1) {
            throw new IllegalArgumentException();
        }
        line = new int[size];
    }

    public void process(int i) {
        int size = line.length;
        if (0 <= i && i < size) {
            for (int j = 0; j < size; j++) {
                if (line[i] < line[j]) {
                    int t = line[i];
                    line[i] = line[j];
                    line[j] = t;
                }
            }
        }
    }

    public String toString() {
        String s = "";
        for (int t : line) {
            s += t;
        }
        return s;
    }

    public void delta(int index, int value) {
        if (index < 0 || index >= line.length) {
            return; // Do nothing if index is out of bounds
        }

        // Calculate the new value at the specified index
        line[index] += value;

        // Ensure the value doesn't exceed Java's int limits
        if (line[index] > Integer.MAX_VALUE) {
            line[index] = Integer.MAX_VALUE; // Cap at max int value
        }
    }

}
