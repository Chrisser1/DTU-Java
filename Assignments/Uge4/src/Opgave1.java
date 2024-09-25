
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Opgave1 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int thirteenScaleInput = 0;
        List<Integer> validInputNumbers = Arrays.asList(0,3,5,6,7,8,9,10,12,13);
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Please enter a valid integer between 0 and 13:");

            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();

                if (validInputNumbers.contains(input)) {
                    thirteenScaleInput = input;
                    validInput = true;
                } else {
                    System.out.println("Input must be between one of the valid inputs " + validInputNumbers + ". Try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Consume invalid input to prevent infinite loop
            }
        }

        printSevenScaleNumber(thirteenScaleInput);
    }

    private static void printSevenScaleNumber(int thirteenScaleInput) {
        switch (thirteenScaleInput) {
            case 0 -> System.out.println(thirteenScaleInput + " as 7-trinsskalaen er: " + -3);
            case 3 -> System.out.println(thirteenScaleInput + " as 7-trinsskalaen er: " + 0);
            case 5 -> System.out.println(thirteenScaleInput + " as 7-trinsskalaen er: " + 0);
            case 6 -> System.out.println(thirteenScaleInput + " as 7-trinsskalaen er: " + 2);
            case 7 -> System.out.println(thirteenScaleInput + " as 7-trinsskalaen er: " + 4);
            case 8 -> System.out.println(thirteenScaleInput + " as 7-trinsskalaen er: " + 7);
            case 9 -> System.out.println(thirteenScaleInput + " as 7-trinsskalaen er: " + 7);
            case 10 -> System.out.println(thirteenScaleInput + " as 7-trinsskalaen er: " + 10);
            case 11 -> System.out.println(thirteenScaleInput + " as 7-trinsskalaen er: " + 12);
            case 13 -> System.out.println(thirteenScaleInput + " as 7-trinsskalaen er: " + 12);
            default -> System.out.println(thirteenScaleInput + " Is not a supported number.");
        }
    }
}
