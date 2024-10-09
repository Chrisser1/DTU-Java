public class Opgave2 {
    public static void main(String[] args) {
        int[] values = {14, 1, 22, 17, 36,7, 43, 5};
        System.out.println("There are " + countInRange(values, 4, 17) + " values in the range [4,17]");
    }

    private static int countInRange(int[] values, int minValue, int maxValue) {
        int count = 0;

        for (int i : values) {
            if (i >= minValue && i <= maxValue) {
                count++;
            }
        }

        return count;
    }
}
