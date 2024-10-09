public class App {
    public static void main(String[] args) throws Exception {
        printDesign();
    }

    public static void printDesign() {
        for (int j = 1; j < 10; j += 2) {
            int lineLength = (11 - j)/2;
            printLine(lineLength);
            for (int k = 0; k < j; k++) {
                System.out.print(j);
            }
            printLine(lineLength);
            System.out.println();
        }
    }

    public static void printLine(int lineLength) {
        for (int i = 0; i < lineLength; i++) {
            System.out.print("-");
        }
    }
}
