
import java.util.Scanner;

public class Opgave2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        smallestLargest(scanner);
    }

    private static void  smallestLargest(Scanner scanner) {
        int amountOfInputs = getAmountOfInputsOrNumber(scanner, true, 0);

        int largestNumber = Integer.MIN_VALUE;
        int smallestNumber = Integer.MAX_VALUE;
        for (int i = 1; i <= amountOfInputs; i++) {
            int input = getAmountOfInputsOrNumber(scanner, false, i);
            if (input > largestNumber) {
                largestNumber = input;
            } else if (input < smallestNumber) {
                smallestNumber = input;
            }
        }

        System.out.println("Smallest = " + smallestNumber);
        System.out.println("Largest = " + largestNumber);
    }

    private static int getAmountOfInputsOrNumber(Scanner scanner, boolean isAmount, int currenNumber) {
        boolean validInput = false;
        int value = 0;
        while (!validInput) {
            if (isAmount) {
                System.out.print("How many numbers do you want to enter? ");
            } else {
                System.out.print("Number" + currenNumber + ": ");
            }

            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value > 0 || !isAmount) {
                    validInput = true;
                } else {
                    System.out.println("Please input a larger number than 0");
                }
            } else {
                System.out.println("Please input a number in the form of a Integer");
            }
        }

        return value;
    }
}
