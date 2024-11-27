import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        // Number of warm-up runs and measured runs
        int warmUpRuns = 5;
        int measuredRuns = 10;

        // Warm-up runs to allow JVM optimizations
        for (int i = 0; i < warmUpRuns; i++) {
            runWordCount();
        }

        // Variables to track the best time
        long bestTime = Long.MAX_VALUE;

        // Measured runs
        for (int i = 0; i < measuredRuns; i++) {
            long start = System.nanoTime();
            runWordCount();
            long end = System.nanoTime();
            long time = end - start;
            System.out.println("Run " + (i + 1) + ": Time taken: " + time + "ns");

            // Update best time
            if (time < bestTime) {
                bestTime = time;
            }
        }

        System.out.println("Best time: " + bestTime + "ns");
    }

    public static void runWordCount() {
        // Use ConcurrentHashMap with LongAdder for efficient thread-safe counts
        Map<String, LongAdder> wordCounter = new ConcurrentHashMap<>();

        try (Stream<String> lines = Files.lines(Paths.get("src/mobydick.txt")).parallel()) {
            lines.forEach(line -> {
                int length = line.length();
                StringBuilder word = new StringBuilder();
                for (int i = 0; i <= length; i++) {
                    char c = (i < length) ? line.charAt(i) : ' ';
                    if (Character.isLetterOrDigit(c)) {
                        if (c >= 'A' && c <= 'Z') {
                            c = (char) (c + ('a' - 'A'));
                        }
                        word.append(c);
                    } else {
                        if (word.length() > 0) {
                            String wordStr = word.toString();
                            wordCounter.computeIfAbsent(wordStr, k -> new LongAdder()).increment();
                            word.setLength(0);
                        }
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

//        // Optionally, print words with count > 2000 outside the timing measurement
//        wordCounter.forEach((word, count) -> {
//            if (count.intValue() > 2000) {
//                System.out.println(word + ": " + count);
//            }
//        });
    }
}
