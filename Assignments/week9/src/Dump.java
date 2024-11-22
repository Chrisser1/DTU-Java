public class Dump {
    private boolean[] line;

    public Dump(int size) {
        if (size < 1) {
            size = 1;
        }

        line = new boolean[size];
    }

    public void create(int value) {
        if (value >= line.length && value < 0) {
            return;
        }

        line[value] = true;
    }

    public void update() {
        int size = line.length;
        boolean[] next = new boolean[size];

        for (int i = 2; i <= size - 3; i++) {
            int n = 0;
            for (int j = -2; j <= 2; j++) {
                if (j == 0) {
                    continue;
                }
                n += line[i + j] ? 1 : 0;
            }

            if (line[i] && (n == 2 || n == 4)) {
                next[i] = true;
            } else if (!line[i] && (n == 2 || n == 3)) {
                next[i] = true;
            }
        }

        line = next;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (boolean state : line) {
            if (state) {
                string.append("X");
            } else {
                string.append("-");
            }
        }
        return string.toString();
    }
}
