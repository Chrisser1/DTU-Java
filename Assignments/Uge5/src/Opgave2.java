import java.io.File;
import java.util.Scanner;

public class Opgave2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input file path: ");
        String filePath = scanner.nextLine();
        scanner.close();
        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            readAllNumbers(fileScanner);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readAllNumbers(Scanner scanner) {
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        int sum = 0;
        int count = 0;
        System.out.println("The numbers are: ");
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                count++;
                sum += number;

                smallest = number < smallest ? number : smallest;
                largest = number > largest ? number : largest;

                System.out.print(number + " ");
            } else {
                scanner.next();
            }
        }

        System.out.println("\nThere were " + count + " numbers.");
        System.out.println("The largest number is " + largest);
        System.out.println("The smallest number is " + smallest);
        System.out.println("The average is " + sum / (double) count);
    }
}
