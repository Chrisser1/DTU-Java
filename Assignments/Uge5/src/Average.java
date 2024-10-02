import java.io.File;
import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        String filePath = "opg05/numberinput2.dat";
        try (Scanner scanner = new Scanner(new File(filePath))) {
            readAllNumbers(scanner);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readAllNumbers(Scanner scanner) {
        double largest = Double.MIN_VALUE;
        double smallest = Double.MAX_VALUE;
        double sum = 0;
        int count = 0;
        System.out.println("The numbers are: ");
        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                double number = scanner.nextDouble();
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
