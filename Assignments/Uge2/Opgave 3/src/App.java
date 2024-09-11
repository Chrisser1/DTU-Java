public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Opgave A");
        a();
        System.out.println("Opgave B");
        b();
        System.out.println("Opgave c");
        c();
    }


    public static void a() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= 2; k++) {
                    System.out.print(j);
                }
            }
            System.out.println();
        }
    }

    public static void b() {
        for (int i = 0; i <= 3; i++) {
            for (int j = 9; j >= 0; j--) {
                for (int k = 0; k <= 3; k++) {
                    System.out.print(j);
                }
            }
            System.out.println();
        }
    }

    public static void c() {
        for (int i = 0; i <= 4; i++) {
            for (int j = 9; j >= 0; j--) {
                    for (int k = 0; k <= j; k++) {
                    System.out.print(j);
                }
            }
            System.out.println();
        }
    }
}
