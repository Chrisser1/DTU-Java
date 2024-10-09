import java.util.Scanner;

public class Opgave4 {
    private static final int DIGITS = 50;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first 50-digit number:");
        String num1 = scanner.nextLine();
        System.out.println("Enter the second 50-digit number:");
        String num2 = scanner.nextLine();

        if (num1.length() > DIGITS || num2.length() > DIGITS) {
            throw new RuntimeException("Number overflow: inputs exceed 50 digits");
        }

        int[] number1 = convertToDigitsArray(num1);
        int[] number2 = convertToDigitsArray(num2);

        // Add the two numbers
        int[] sum = addLargeNumbers(number1, number2);

        // Display the result
        System.out.println("Sum: " + arrayToString(sum));
    }

    private static int[] convertToDigitsArray(String number) {
        int[] digits = new int[DIGITS];

        for (int i = 0; i < number.length(); i++) {
            digits[DIGITS - number.length() + i] = number.charAt(i) - '0';
        }

        return digits;
    }

    private static int[] addLargeNumbers(int[] num1, int[] num2) {
        int[] result = new int[DIGITS + 1]; // Allow for an extra digit in case of carry overflow
        int carry = 0;

        // Add the numbers starting from the least significant digit
        for (int i = DIGITS - 1; i >= 0; i--) {
            int sum = num1[i] + num2[i] + carry;
            result[i + 1] = sum % 10;
            carry = sum / 10; // Carry over the tens digit
        }

        // Handle the final carry
        result[0] = carry;

        return result;
    }

    private static String arrayToString(int[] array) {
        String result = "";
        boolean leadingZero = true;

        // Skip leading zeros, except when the number is zero
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                leadingZero = false;
            }
            if (!leadingZero || i == array.length - 1) {
                result += array[i];
            }
        }

        return result;
    }
}
