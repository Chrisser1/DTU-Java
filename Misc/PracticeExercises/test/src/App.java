import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class App {
    static Author h = new Author("Christoffer", 20);
    public static void main(String[] args) throws IOException {
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "Input your name" + ConsoleColors.RESET);

        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in)
        );

        String name = reader.readLine();

        System.out.println(ConsoleColors.GREEN_BOLD + "Your name is: "+ name);
        System.out.println(ConsoleColors.RED_BOLD_BRIGHT + h);
        System.out.print(ConsoleColors.RESET);
    }
}
