import java.util.concurrent.ThreadLocalRandom;

public class BuffonsNeedle {

    public static final int NEEDLE_AMOUNT = 100_000_000;
    private static final double PI_DIV_180 = Math.PI / 180; // Conversion factor from degrees to radians

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int hits = 0;

        for (int i = 0; i < NEEDLE_AMOUNT; i++) {
            double angle = random.nextDouble(0, 180);
            double distance = random.nextDouble(0, 2);

            // Check if needle hits a line
            if (needleHitLine(distance, angle)) {
                hits++;
            }
        }

        System.out.println("Dropped " + NEEDLE_AMOUNT + " needles. " + hits + " of them hit.");
        double piApprox = (double) NEEDLE_AMOUNT / (double) hits;
        System.out.println(NEEDLE_AMOUNT + " / " + hits + " = " + piApprox);

        long end = System.currentTimeMillis();
        System.out.println("It took " + (end - start) + "ms");
    }

    public static boolean needleHitLine(double distance, double angleDegrees) {
        // Convert angle to radians for Math.sin (use precomputed PI_DIV_180)
        double angleRadians = angleDegrees * PI_DIV_180;
        // Calculate the top position using the sine function
        double topPosition = Math.sin(angleRadians) + distance;
        return (topPosition >= 2);
    }
}
