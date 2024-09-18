public class FizzBuzz {
    public static void main(String[] args) {
        for (int i = 1; i <= 30; i++) {
            boolean a = i % 3 == 0; // check if the number is divisible by 3
            boolean b = i % 5 == 0; // check if the number is divisible by 5

            System.out.print(a ? "Fizz" : ""); // if a is true then print Fizz else nothing
            System.out.print(b ? "Buzz" : ""); // if b is true then print Buzz else nothing
            /* if a and b is false then print
               the current number on a new line
               else print nothing and go to a new line */
            System.out.println(!a && !b ? i : "");
        }
    }
}
