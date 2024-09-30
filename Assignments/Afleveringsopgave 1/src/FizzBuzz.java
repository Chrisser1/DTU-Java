public class FizzBuzz {
    public static void main(String[] args) {
        for (int i = 1; i <= 30; i++) {
            // Checking divisibility of number i and assigning truth value to boolean
            boolean fizz = i % 3 == 0;
            boolean buzz = i % 5 == 0; 

            System.out.print(fizz ? "Fizz" : "");
            System.out.print(buzz ? "Buzz" : "");
            System.out.println(!fizz && !buzz ? i : ""); // If neither fizz or buzz, print number, else nothing and new line
        }
    }
}
