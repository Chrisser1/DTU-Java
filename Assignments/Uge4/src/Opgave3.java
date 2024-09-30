
import java.util.Scanner;

public class Opgave3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please input a word: ");
        String word = scanner.nextLine();

        printLetters(word);
    }

    private static void printLetters(String word) {
        for (int i = 0; i < word.length(); i++) {
            System.out.print(word.charAt(i));

            if (i < word.length() - 1) {
                System.out.print("_");
            }
        }
    }

}
