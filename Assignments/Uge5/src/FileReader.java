import java.io.File;
import java.util.Scanner;

public class FileReader {
    public static void main(String[] args) throws Exception {
        String filePath = "opg05/problem2.html";
        try (Scanner scanner = new Scanner(new File(filePath))) {
            String values = readEntireFile(scanner);
            System.out.println("The entire file is:\n" + values + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (Scanner scanner = new Scanner(new File(filePath))) {
            stripHtmlTags(scanner);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String readEntireFile(Scanner scanner) {
        String out = "";
        while (scanner.hasNextLine()) {
            out += scanner.nextLine();
            if (scanner.hasNextLine()) {
                out += "\n";
            }
        }
        return out;
    }

    private static void stripHtmlTags(Scanner scanner) {
        String originalText = "";
        String modifiedText = "";

        while (scanner.hasNextLine()) {
            originalText += scanner.nextLine();
            if (scanner.hasNextLine()) {
                originalText += "\n";
            }
        }

        byte[] indexes = new byte[originalText.length()];
        for (int i = 0; i < originalText.length(); i++) {
            char character = originalText.charAt(i);

            if (character == '<') {
                indexes[i] = 1;
            }

            if (character == '>') {
                indexes[i] = 2;
            }
        }


        boolean isHtmlTag = false;
        for (int i = 0; i < indexes.length; i++) {
            if (indexes[i] == 1 && hasEnd(i, indexes)) {
                isHtmlTag = true;
            } else if (indexes[i] == 2) {
                if (isHtmlTag) {
                    isHtmlTag = false;
                    continue;
                }
                isHtmlTag = false;
            }

            if (!isHtmlTag) {
                modifiedText += originalText.charAt(i);
            }
        }
        scanner.reset();
        System.out.println("The striped file is:\n" + modifiedText + "\n");
    }

    private static boolean hasEnd(int index, byte[] indexes) {
        for (int i = index; i < indexes.length; i++) {
            if (indexes[i] == 2) {
                return true;
            }
        }
        return false;
    }
}
