public class FizzBuzz {
    public static void main(String[] args) {
        for (int i = 1; i <= 30; i++) {
            // checking divisibility of number i and assigning truth value to boolean
            boolean a = i % 3 == 0;
            boolean b = i % 5 == 0; 

            System.out.print(a ? "Fizz" : ""); // if a is true then print Fizz else nothing
            System.out.print(b ? "Buzz" : ""); // if b is true then print Buzz else nothing
            System.out.println(!a && !b ? i : ""); // if not a and not b, print number, else nothing and new line
        }
    }
}
