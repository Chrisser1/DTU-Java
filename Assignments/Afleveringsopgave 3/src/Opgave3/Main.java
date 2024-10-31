import java.util.Scanner;
import java.util.Random;
import java.awt.Color;
import java.awt.Font;

public class Main{
    public static int WIDTH = 1000;
    public static int HEIGHT = 1000;

    public static void main(String[] args) {
        StdDraw.setCanvasSize(WIDTH,HEIGHT);
        StdDraw.setPenColor(0, 0, 0);
        StdDraw.text(WIDTH/2, HEIGHT/2, "Look in your terminal :)");
        Scanner scanner = new Scanner(System.in);
        /*
        drawRaceTrack(getValidInt(scanner, 0, 100, true), 3, 3);
        for (int i = 0; i<7; i++){
            drawRaceTrack(getValidInt(scanner,1,10,true),i+3,i+3);
        }
        while (true){
            drawDefaultTrack(getValidInt(scanner, 0, 100, true));
        }
        */
    }

    




    private static int getValidInt(Scanner scanner, int min, int max, boolean presetMessages) {
        if (presetMessages) {
            System.out.print("Enter an integer in the interval ["+min+","+max+"]:");
        }
        int number = min-1;
        boolean validInput = false;

        while (!validInput) {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number >= min && number <= max) {
                    validInput = true;
                } else {
                    System.out.println("Input must be in the interval ["+min+","+max+"], try again:");
                }
            } else {
                System.out.println("Invalid input - not an integer. Please enter an integer in the interval ["+min+","+max+"]:");
                scanner.next();  // consume the invalid input
            }
        }
        if (presetMessages){
            System.out.println("Accepted input: " + number);
        }
        return number;
    }

    private static int getValidInt(Scanner scanner){
        return getValidInt(scanner, 0, 2147483647, false);
    }
}