import java.util.Scanner;

public class RomanNumerals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = getValidInt(scanner);
        String numberAsString = String.valueOf(number);
        System.out.println("The roman number is: " + getRomanNumber(numberAsString));
    }

    private static int getValidInt(Scanner scanner) {
        System.out.print("Enter a positive integer larger than 0: ");
        int number = 0;
        boolean validInput = false;

        while (!validInput) {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number > 0 && number < 4000) {
                    validInput = true;
                } else {
                    System.out.println("Please enter a positive integer in the interval 1-3999.");
                    System.out.print("Enter a positive integer: ");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid positive integer.");
                System.out.print("Enter a positive integer: ");
                scanner.next();  // consume the invalid input
            }
        }
        System.out.println("You entered a valid positive integer: " + number);
        return number;
    }

    private static String addThousands(int thousands) {
        if (thousands <= 0) {
            return "";
        }
        String output = "";

        for (int i = 0; i < thousands; i++) {
            output += "M";
        }
        return output;
    }

    private static String addHundreds(int hundreds) {
        String output = "";
        switch (hundreds) {
            case 1 -> output = "C";
            case 2 -> output = "CC";
            case 3 -> output = "CCC";
            case 4 -> output = "CD";
            case 5 -> output = "D";
            case 6 -> output = "DC";
            case 7 -> output = "DCC";
            case 8 -> output = "DCCC";
            case 9 -> output = "CM";
            default -> output = "";
        }
        return output;
    }

    private static String addTens(int tens) {
        String output = "";
        switch (tens) {
            case 1 -> output = "X";
            case 2 -> output = "XX";
            case 3 -> output = "XXX";
            case 4 -> output = "XL";
            case 5 -> output = "L";
            case 6 -> output = "LX";
            case 7 -> output = "LXX";
            case 8 -> output = "LXXX";
            case 9 -> output = "XC";
            default -> output = "";
        }
        return output;
    }

    private static String addSingleDigit(int digit){
        String output = "";
        switch (digit) {
            case 1 -> output = "I";
            case 2 -> output = "II";
            case 3 -> output = "III";
            case 4 -> output = "IV";
            case 5 -> output = "V";
            case 6 -> output = "VI";
            case 7 -> output = "VII";
            case 8 -> output = "VIII";
            case 9 -> output = "IX";
            default -> output = "";
        }
        return output;
    }

    private static String getRomanNumber(String numberAsString) {
        String output = "";
        // Splitter string ad i len antal int's
        // Hvis 4 kør alle 4 funktioner osv. nedad.
        int len = numberAsString.length();
        if (len > 3) {
            output += addThousands(Character.getNumericValue(numberAsString.charAt(0)));
        }
        if (len > 2){
            output += addHundreds(Character.getNumericValue(numberAsString.charAt(len - 3)));
        }
        if (len > 1){
            output += addTens(Character.getNumericValue(numberAsString.charAt(len - 2)));
        }
        output += addSingleDigit(Character.getNumericValue(numberAsString.charAt(len - 1)));
        return output;
    }
}
