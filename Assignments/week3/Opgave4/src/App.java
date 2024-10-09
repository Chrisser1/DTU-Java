public class App {
    public static void main(String[] args) throws Exception {
        printPowersOf2(3);
        printPowersOf2(10);
    }

    private static void printPowersOf2(int  maximum_number) {
        for (int i = 0; i <= maximum_number; i++) {
            System.out.print((int) Math.pow(2, i) + " ");
        }
        System.out.println();
    }
}
