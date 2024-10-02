import java.util.Scanner;

public class Opgave2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a word: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)){
            System.out.println("'" + input + "' is a palindrome!");
        } else {
            System.out.println("'" + input + "' is not a palindrome!");
        }
    }

    private static String reverse(String input) {
        String result = "";
        for (int i = 1; i <= input.length(); i++) {
            result += input.charAt(input.length() - i);
        }
        return result;
    }

    private static boolean isPalindrome(String input) {
        input = input.toLowerCase();
        // Use regular expression to match all non-alphabetic characters and replace with empty string
        input = input.replaceAll("[^a-z]", "");
        return input.equals(reverse(input));
    }
}
