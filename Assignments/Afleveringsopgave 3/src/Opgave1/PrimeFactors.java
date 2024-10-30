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
        // Print alle 2'ere som primfaktorer
        while (value % 2 == 0) {
            System.out.print(2 + ", ");
            value /= 2;
        }

        // Nu er value ulige. Vi kan hoppe over lige tal
        for (long i = 3; i * i <= value; i += 2) {
            //  break in case of overflow
            if (i * i < 0) {
                System.out.println("Overflow happened!");
                break;
            }
            while (value % i == 0) {
                System.out.print(i + ", ");
                value /= i;
            }
        }

        // Hvis value er et primtal større end 2
        if (value > 2) {
            System.out.print(value);
        }
        System.out.println();
    }
}
