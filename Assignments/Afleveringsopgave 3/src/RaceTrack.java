import java.util.Scanner;
import java.util.Random;
import java.awt.Color;
import java.awt.Font;

public class RaceTrack{
    public static int WIDTH = 1000;
    public static int HEIGHT = 1000;

    public static void main(String[] args) {
        StdDraw.setCanvasSize(WIDTH,HEIGHT);
        StdDraw.setPenColor(0, 0, 0);
        StdDraw.text(WIDTH/2, HEIGHT/2, "Look in your terminal :)");
        Scanner scanner = new Scanner(System.in);
        drawRaceTrack(getValidInt(scanner, 0, 100, true), 3, 3);
        for (int i = 0; i<7; i++){
            drawRaceTrack(getValidInt(scanner,1,10,true),i+3,i+3);
        }
        while (true){
            drawDefaultTrack(getValidInt(scanner, 0, 100, true));
        }
    }

    private static void drawDefaultTrack(int laneWidth){
        drawRaceTrack(laneWidth, 4, 4);
    }

    private static void drawRaceTrack(int laneWidth, int trackWidth, int trackLength){
        Color backgroundColor = new Color(50,130,130);
        Color trackColor = new Color(200,230,250);
        Color trackStrokeColor = new Color(100,130,150);

        int gridWidth = laneWidth*trackWidth;
        int gridLength = laneWidth*trackLength;
        int squareSizePx = 5;

        int mapWidthPx = gridWidth*squareSizePx;
        int mapLengthPx = gridLength*squareSizePx;
        int marginPx = 10;

        StdDraw.setXscale(-marginPx,mapWidthPx+marginPx);
        StdDraw.setYscale(-marginPx,mapLengthPx+marginPx);

        // Drawing background
        StdDraw.setPenColor(backgroundColor);
        StdDraw.filledSquare(mapWidthPx/2, mapLengthPx/2, Math.max(mapWidthPx, mapLengthPx)/2+marginPx);

        // Drawing squares for track with specific width and length
        for (int r = 1; r <= gridWidth; r++){
            for (int k = 1; k <= gridLength; k++){
                double xPos = r-0.5;
                double yPos = k-0.5;
                double xPosUpscaled = xPos*squareSizePx;
                double yPosUpscaled = yPos*squareSizePx;
                //!!KAN ERSTATTES MED ET ENKELT REKTANGEL
                //StdDraw.setPenColor(trackColor);
                //StdDraw.filledSquare(xPosUpscaled, yPosUpscaled,(double) squareSizePx/2); 
                StdDraw.setPenColor(trackStrokeColor);
                StdDraw.square(xPosUpscaled, yPosUpscaled,(double) squareSizePx/2);
            }
        }
        double centerX = mapWidthPx/2;
        double centerY = mapLengthPx/2;
        if (mapWidthPx % 2 == 1){centerX+=0.5;}
        if (mapLengthPx % 2 == 1){centerY+=0.5;}
        double centerRectWidth = (mapWidthPx/trackWidth)*(trackWidth-2)*0.5;
        double centerRectLength = (mapLengthPx/trackLength)*(trackWidth-2)*0.5;
        
        StdDraw.setPenColor(backgroundColor);
        StdDraw.filledRectangle(centerX, centerY, centerRectWidth, centerRectLength);
        StdDraw.setPenColor(trackStrokeColor);
        StdDraw.rectangle(centerX, centerY, centerRectWidth, centerRectLength);

        //StdDraw.line(5*laneWidth,10,10*laneWidth,10*laneWidth);
        //StdDraw.filledCircle(laneWidth, laneWidth, 1);
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