import java.util.Scanner;
import java.awt.Color;

public class Main{
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 1000;
    public static final int SQUARE_SIZE_PX = 5;
    public static final Color BACKGROUND_COLOR = new Color(50,130,130);
    public static final Color TRACK_COLOR = new Color(200,230,250);
    public static final Color TRACK_STROKE_COLOR = new Color(100,130,150);

    public static void main(String[] args) {
        StdDraw.setCanvasSize(WIDTH,HEIGHT);
        Scanner scanner = new Scanner(System.in);
        RaceTrack track = RaceTrack.create("Square");
        track.initTrackFrame();
        track.displayGrid();
        //track.display();
        BoundingBox testBox1 = new BoundingBox(1, 1, 4, 4, true);
        BoundingBox testBox2 = new BoundingBox(1, 5, 4, 8, true);
        BoundingBox testBox3 = new BoundingBox(5, 1, 8, 4, true);
        BoundingBox testBox4 = new BoundingBox(5, 5, 8, 8, true);
        testBox1.display(BACKGROUND_COLOR);
        testBox2.display(BACKGROUND_COLOR);
        testBox3.display(BACKGROUND_COLOR);
        testBox4.display(BACKGROUND_COLOR);

        while (true) {
            // Check if the mouse is pressed
            if (StdDraw.mousePressed()) {
                System.out.println("MOUSE PRESSED RAHHH");
                // Get the current mouse coordinates
                int x = (int) StdDraw.mouseX();
                int y = (int) StdDraw.mouseY();

                testBox1.drawIfSelected(x, y, false);
                testBox2.drawIfSelected(x, y, false);
                testBox3.drawIfSelected(x, y, false);
                testBox4.drawIfSelected(x, y, false);

                while (StdDraw.mousePressed()) {
                }
            }
        }
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