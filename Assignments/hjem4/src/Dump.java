public class Dump {
    private int[] line;

    public Dump(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("Size must be at least one");
        }

        this.line = new int[size];
    }

    public void delta(int i, int t) {
        // Check if the index i is within bounds
        if (i < 0 || i >= this.line.length) {
            return; // If not, do nothing
        }

        // Calculate the new value of the element
        int newValue = this.line[i] + t;

        // Update the value if it's between 0 and 9, inclusive
        if (newValue >= 0 && newValue <= 9) {
            this.line[i] = newValue;
        }
    }

    public void process(int i) {
        if (i < 0 && i > this.line.length) {
            return;
        }

        int x = this.line[i];
        for (int j = 0; j < this.line.length; j++) {
            int newValue = this.line[j];
            if (x < newValue) {
                this.line[i] = newValue;
                this.line[j] = x;
                x = newValue;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < line.length; i++) {
            s.append(line[i]);
        }

        return s.toString();
    }


}
