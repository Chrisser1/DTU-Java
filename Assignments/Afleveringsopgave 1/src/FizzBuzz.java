public class FizzBuzz {
    public static void main(String[] args) {
        for (int i = 1; i <= 30; i++) {
            boolean a = i % 3 == 0;
            boolean b = i % 5 == 0;

            System.out.print(a ? "Fizz" : "");
            System.out.print(b ? "Buzz" : "");
            System.out.println(!a && !b ? i : "");
        }
    }
}
