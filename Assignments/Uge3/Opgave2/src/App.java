import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        processName(scanner);
    }

    private static void processName(Scanner scanner) {
        System.out.print("Please enter your full name: ");
        String name = scanner.nextLine();
        int split_index = name.indexOf(" ");

        System.out.print("Your name in reverse order is");
        for (int i = split_index; i < name.length(); i++) {
            System.out.print(name.charAt(i));
        }
        System.out.print(", ");
        for (int i = 0; i < split_index; i++) {
            System.out.print(name.charAt(i));
        }
        System.out.println();
    }
}
