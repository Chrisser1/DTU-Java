import java.util.Scanner;

public class Palindrome {
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

    private static String reverse(String input) { // Vender et string om
        String result = "";
        for (int i = 1; i <= input.length(); i++) {
            result += input.charAt(input.length() - i);
        }
        return result;
    }

    private static boolean isPalindrome(String input) { // Returnerer sand hvis input-string er identisk med input-string vendt om.
        input = input.toLowerCase();
        // Use regular expression to match all non-alphabetic characters and replace with empty string
        input = input.replaceAll("[^a-z]", "");
        return input.equals(reverse(input)); 
    }
}
