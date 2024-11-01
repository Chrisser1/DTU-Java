package Opgave3;
import java.util.Scanner;
import java.awt.Color;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;

public class Main{
    public static final int WIDTH = 1000;
    public static final int LENGTH = 1000;
    public static final int SQUARE_SIZE_PX = 5;
    public static final Color BACKGROUND_COLOR = new Color(50,130,130);
    public static final Color TRACK_COLOR = new Color(200,230,250);
    public static final Color TRACK_STROKE_COLOR = new Color(100,130,150);
    public static final Color GRID_DOT_COLOR = new Color(0,0,0);
    public ArrayList<RaceTrack> raceTracks = new ArrayList<>();
    public static RaceTrack selectedTrack;

    public static void main(String[] args) {
        StdDraw.setCanvasSize(WIDTH,LENGTH);
        Scanner scanner = new Scanner(System.in);
        RaceTrack trackChooser = RaceTrack.create("TrackChooser");
        selectedTrack = trackChooser;

        RaceTrack leaTrack = RaceTrack.create("Lea");

        trackChooser.initTrackFrame();
        trackChooser.displayGrid();
        //track.display();
        trackChooser.displayAllBoundingBoxes();
        

        while (true) {
            // Check if the mouse is pressed
            if (StdDraw.mousePressed()) {
                System.out.println("MOUSE PRESSED RAHHH");
                // Get the current mouse coordinates
                int x = (int) StdDraw.mouseX();
                int y = (int) StdDraw.mouseY();

                for (BoundingBox box : trackChooser.getInclusiveBoundingBoxes()){
                    box.drawIfSelected(x, y, false);
                }

                resetBackground();
                leaTrack.initTrackFrame();
                leaTrack.displayGrid();
                leaTrack.displayAllBoundingBoxes();

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

    private static void resetBackground(){
        StdDraw.setPenColor(BACKGROUND_COLOR);

        StdDraw.filledSquare(selectedTrack.getMapWidthPx()/2, selectedTrack.getMapLengthPx()/2, selectedTrack.getMaxMargin()+Math.max(selectedTrack.getMapLengthPx(),selectedTrack.getMapWidthPx()));
    }
}