import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        byte cups = 0b001; // Initial position: only the first cup is active

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        for (char character : input.toCharArray()) {
            switch (character) {
                case 'A':
                    // Swap bits 0 and 1
                    cups = swapBits(cups, 0, 1);
                    break;
                case 'B':
                    // Swap bits 1 and 2
                    cups = swapBits(cups, 1, 2);
                    break;
                case 'C':
                    // Swap bits 0 and 2
                    cups = swapBits(cups, 0, 2);
                    break;
                default:
                    break;
            }
        }

        System.out.println(Integer.numberOfTrailingZeros(cups) + 1);
    }

    public static byte swapBits(byte n, int i, int j) {
        // Extract the bits at positions i and j
        byte bitI = (byte) ((n >> i) & 1); // Get the i-th bit
        byte bitJ = (byte) ((n >> j) & 1); // Get the j-th bit

        // If the bits are different, we need to swap them
        if (bitI != bitJ) {
            // Create a mask to swap the bits
            byte bitMask = (byte) ((1 << i) | (1 << j));
            // Toggle the bits using XOR
            n ^= bitMask;
        }

        return n; // Return the modified number with swapped bits
    }
}
