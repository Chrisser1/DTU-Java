public class App {
    public static void main(String[] args) throws Exception {
        printNumbers(15);
        printNumbers(5);
    }

    public static void printNumbers(int maximum_number) {
        for (int i = 1; i <= maximum_number; i++) {
            System.err.print("[" + i + "] ");
        }
        System.out.println();
    }
}
