import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(new File("opg05/numberinput2.dat"))) {
            while (scanner.hasNext()) {
                if (scanner.hasNextDouble()) { // Check if it is a valid number
                    System.out.println(scanner.next());
                } else {
                    scanner.next(); // Consume invalid input
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
