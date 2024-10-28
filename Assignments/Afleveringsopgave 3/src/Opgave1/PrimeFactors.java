package Opgave1;
import java.util.Scanner;

public class PrimeFactors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long value = 0;
        while (true) {
            // Get a valid user input
            value = getValidInput(scanner);

            if (value == 0) {
                System.out.println("Terminating program.");
                break;
            }
            System.out.println("Prime factors of " + value + " are:");
            findPrimeFactors(value);
        }
    }

    private static long getValidInput(Scanner scanner) {
        Boolean validInput = false;
        long value = 0;
        while (!validInput) {
            System.out.println("Enter integer greater than 1 (0 to terminate): ");
            if (scanner.hasNextLong()) {
                value = scanner.nextLong();
                validInput = true;
            } else {
                System.out.println("Not a valid integer, please try again");
                scanner.next();
            }
        }
        return value;
    }

    private static void findPrimeFactors(long value) {
        long divisor = 2; // smallest prime number
        boolean first = true;
        // While value is greater than 1, find prime factors
        while (divisor * divisor <= value) {
            // While the divisor can divide the value, it's a prime factor
            if (value % divisor == 0) {
                System.out.print(divisor + ", ");

                value /= divisor;
            } else {
                // we plus with two the second time (even numbers except 2 is not prime)
                if (first) {
                    first = false;
                    divisor++;
                } else {
                    divisor += 2;
                }
            }
        }
        if (value != 1) {
            System.out.print(value);
        }
        System.out.println();
    }
}
