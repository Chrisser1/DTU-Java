import java.util.Scanner;

public class PrimeFactors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long value = 0;
        while (true) {
            value = getValidInput(scanner);

            if (value == 0) {
                break;
            }

            
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
}
