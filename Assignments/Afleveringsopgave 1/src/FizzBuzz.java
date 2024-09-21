public class FizzBuzz {
    public static void main(String[] args) {
        for (int i = 1; i <= 30; i++) {
            // checking divisibility of number i and assigning truth value to boolean
            boolean fizz = i % 3 == 0;
            boolean buzz = i % 5 == 0; 

            System.out.print(fizz ? "Fizz" : ""); // if fizz is true then print Fizz else nothing
            System.out.print(buzz ? "Buzz" : ""); // if buzz is true then print Buzz else nothing
            System.out.println(!fizz && !buzz ? i : ""); // if neither fizz or buzz, print number, else nothing and new line
        }
    }
}
