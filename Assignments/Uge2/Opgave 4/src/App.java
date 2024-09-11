public class App {
    public static void main(String[] args) throws Exception {
        int fiboNumber;
        int fiboNumberPrev1 = 1;
        int fiboNumberPrev2 = 1;

        for (int k = 0; k <= 100; k++) {
            if (k <= 2 ) {
                fiboNumber = 1;
            } else {
                fiboNumber = fiboNumberPrev1 + fiboNumberPrev2;
                fiboNumberPrev2 = fiboNumberPrev1;
                fiboNumberPrev1 = fiboNumber;
            }
            System.out.println(fiboNumber);
        }
    }
}
