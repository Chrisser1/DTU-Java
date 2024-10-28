import java.util.Scanner;

public class Opgave4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        printFaktorer(number);

        scanner.close();
    }

    private static void printFaktorer(int number) {
        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
            return;
        }

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                System.out.print(i);

                if (i != number) {
                    System.out.print("_");
                }
            }
        }

        System.out.println();
    }
}
