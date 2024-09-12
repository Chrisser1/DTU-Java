public class UsingClassConstant {
    public static final int LINES = 3;

    public static void main(String[] args) {
        for (int i = 0; i < LINES; i++) {
            for (int j = 0; j < LINES; j++) {
                System.out.print("+-");
            }
            System.out.println("+");
        }
    }
}
