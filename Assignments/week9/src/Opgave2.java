import java.util.function.IntBinaryOperator;
public class Opgave2 {
    public static void main(String[] args) {
        test(10, 20, (x,y) -> {
            if (x > y) {
                return x;
            } else {
                return y;
            }
        });
    }

    private static void test(int x, int y, IntBinaryOperator operator) {
        System.out.println("x = " + x + ", y = " + y + " | max = " + operator.applyAsInt(x, y));
    }
}
