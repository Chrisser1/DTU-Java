import java.util.*;

public class BuffonsNeedle {

    public static final int NEEDLE_AMOUNT = 100_000_000;

    public static void main(String[] args) {
        Random random = new Random();
        int hits = 0;

        for (int i = 0; i < NEEDLE_AMOUNT; i++) {
            // Generates a new needle
            double angle = random.nextDouble(0, 180);
            double distance = random.nextDouble(0, 2);
            double angleRadians = angle * (Math.PI / 180);

            // Check if needle hits a line
            if (needleHitLine(distance, angleRadians)) {
                hits++;
            }
        }

        System.out.println("Dropped " + NEEDLE_AMOUNT + " needles. " + hits + " of them hit.");
        double piApprox = (double) NEEDLE_AMOUNT / (double) hits;
        System.out.println(NEEDLE_AMOUNT + " / " + hits + " = " + piApprox);
    }

    public static boolean needleHitLine(double distance, double angleRadians) {
        // Calculate the top position using the sine function
        double topPosition = Math.sin(angleRadians) + distance;
        return (topPosition >= 2);
    }
}
