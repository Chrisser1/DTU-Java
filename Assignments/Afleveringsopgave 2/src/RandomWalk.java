import java.util.Scanner;
import java.util.Random;
import java.awt.Color;

public class RandomWalk {
    public static void main(String[] args) {
        StdDraw.setCanvasSize(800, 800);
        Scanner scanner = new Scanner(System.in);
        Random random = new Random("Zilas".hashCode());
        int size = getValidInt(scanner);
        double margin = 0.02 * size; // Add a small margin around the grid
        StdDraw.setXscale(-size - margin, size + margin);
        StdDraw.setYscale(-size - margin, size + margin);

        // Init the position to (0,0)
        int posX = 0;
        int posY = 0;

        boolean isInRange = true;
        int stepCount = 0;
        while (isInRange) {
            // Smooth color transition using HSB (Hue, Saturation, Brightness)
            // Hue ranges from 0 to 1, so we map stepCount to a value between 0 and 1
            float hueIncrement = 0.0001f;  // Smaller increment for smoother transition
            float hue = (stepCount * hueIncrement) % 1.0f;  // Cycle through hues
            Color color = Color.getHSBColor(hue, 1.0f, 1.0f);  // Full saturation and brightness
            StdDraw.setPenColor(color);
            StdDraw.filledCircle(posX, posY, 0.5);

            // Do a random walk
            switch (random.nextInt(0, 4)) {
                case 0 -> posX++;
                case 1 -> posX--;
                case 2 -> posY++;
                case 3 -> posY--;
                default -> System.err.println("Invalid movement detected");
            }

            // Check if we are in bounds
            if (posX < -size || posX > size || posY < -size || posY > size) {
                isInRange = false;
            } else {
                // If we are print the position and add one to the step counter
                System.out.println("Position = (" + posX + "," + posY + ")");
                stepCount++;
            }
        }
        System.out.println("Total number of steps = " + stepCount);
    }

    private static int getValidInt(Scanner scanner) {
        System.out.print("Enter the size of the grid as positive integer larger than 0: ");
        int number = 0;
        boolean validInput = false;

        while (!validInput) {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number > 0) {
                    validInput = true;
                } else {
                    System.out.println("Please enter a positive integer in the interval 1-infinity.");
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
}
