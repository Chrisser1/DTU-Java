
import java.util.Arrays;

public class Opgave3 {
    public static void main(String[] args) {
        int[] array = {27, 15, 15, 11, 27, 11, 234, 5435, 15};
        int result = mode(array);
        int result2 = mode2(array);
        System.out.println("Mode: " + result);
        System.out.println("Mode2: " + result2);
    }

    private static int mode(int[] array) {
        int[] frequency = new int[101];
        int maxFrequency = 0;
        int mode = Integer.MAX_VALUE;

        for (int num : array) {
            // Make sure that a number larger than 100 doesn't kill the program
            if (num > 100) {
                continue;
            }
            frequency[num]++;

            // Update max frequency and mode
            if (frequency[num] > maxFrequency || (frequency[num] == maxFrequency && num < mode)) {
                maxFrequency = frequency[num];
                mode = num;
            }
        }

        return mode;
    }

    private static int mode2(int[] array) {
        Arrays.sort(array);

        int highestCount = 0;
        int count = 1;
        int currentNumber = array[0];
        int mostFrequentNumber = array[0];

        // Loop through the sorted array, starting from the second element
        for (int i = 1; i < array.length; i++) {
            if (array[i] == currentNumber) {
                count++;
            } else {
                // If the current number changes, compare and reset the count
                if (count > highestCount) {
                    highestCount = count;
                    mostFrequentNumber = currentNumber;
                }
                currentNumber = array[i];
                count = 1;
            }
        }

        // In case the most frequent number is at the end of the array we check for that
        if (count > highestCount) {
            mostFrequentNumber = currentNumber;
        }

        return mostFrequentNumber;
    }
}
