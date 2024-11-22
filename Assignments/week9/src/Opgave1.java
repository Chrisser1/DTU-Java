import java.util.function.IntUnaryOperator;
import java.math.*;

public class Opgave1 {
    public static void main(String[] args) throws Exception {
        test(10, (x) -> x * x);
    }


    private static void test(int x, IntUnaryOperator operator) {
        System.out.println("x = " + x + ", x^2 = " + operator.applyAsInt(x));
    }
}
