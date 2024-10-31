import java.awt.Color;
import java.util.ArrayList;



public class RaceTrack {
    private int gridWidth = 0; 
    private int gridLength = 0;
    private int mapWidthPx = 0;
    private int mapLengthPx = 0;
    private int xMarginPx = 10;
    private int yMarginPx = 10;

    private ArrayList<BoundingBox> inclusiveBoxes;
    private ArrayList<BoundingBox> exclusiveBoxes;

    private RaceTrack(int width, int length){
        this.gridWidth = width;
        this.gridLength = length;

        this.mapWidthPx = gridWidth*Main.SQUARE_SIZE_PX;
        this.mapLengthPx = gridLength*Main.SQUARE_SIZE_PX;
    }

    public static RaceTrack create(String premadeTrackID) {
        switch (premadeTrackID) {
            case "Square" -> {
                return new RaceTrack(10,10);
            }
            case "Rectangular" -> {
                return new RaceTrack(20,10);
            }
            default -> {
                throw new IllegalArgumentException("Invalid track: " + premadeTrackID);
            }   
        }
    }

    public void initTrackFrame(){
        StdDraw.setXscale(-xMarginPx,mapWidthPx+xMarginPx);
        StdDraw.setYscale(-yMarginPx,mapLengthPx+yMarginPx);
    }

    public void displayGrid(){
        Color trackStrokeColor = new Color(100,130,150);
        for (int row = 0; row <= gridWidth; row++){
            for (int column = 0; column <= gridLength; column++){ 
                StdDraw.setPenColor(trackStrokeColor);
                StdDraw.filledCircle(row*5, column*5, 0.2);
            }
        }
    }

    public void display(){
        int gridWidth = 2*this.gridWidth;
        int gridLength = 2*this.gridLength;
        int squareSizePx = 5;

        int mapWidthPx = gridWidth*squareSizePx;
        int mapLengthPx = gridLength*squareSizePx;
        int marginPx = 10;

        StdDraw.setXscale(-marginPx,mapWidthPx+marginPx);
        StdDraw.setYscale(-marginPx,mapLengthPx+marginPx);

        // Drawing background
        StdDraw.setPenColor(Main.BACKGROUND_COLOR);
        StdDraw.filledSquare(mapWidthPx/2, mapLengthPx/2, Math.max(mapWidthPx, mapLengthPx)/2+marginPx);

        // Drawing squares for track with specific width and length
        for (int r = 1; r <= gridWidth; r++){
            for (int k = 1; k <= gridLength; k++){
                double xPos = r-0.5;
                double yPos = k-0.5;
                double xPosUpscaled = xPos*squareSizePx;
                double yPosUpscaled = yPos*squareSizePx;
                //!!KAN ERSTATTES MED ET ENKELT REKTANGEL
                StdDraw.setPenColor(Main.TRACK_COLOR);
                StdDraw.filledSquare(xPosUpscaled, yPosUpscaled,(double) squareSizePx/2); 
                StdDraw.setPenColor(Main.TRACK_STROKE_COLOR);
                StdDraw.square(xPosUpscaled, yPosUpscaled,(double) squareSizePx/2);
            }
        }
        double centerX = mapWidthPx/2;
        double centerY = mapLengthPx/2;
        if (mapWidthPx % 2 == 1){centerX+=0.5;}
        if (mapLengthPx % 2 == 1){centerY+=0.5;}
        double centerRectWidth = (mapWidthPx/gridWidth)*(gridWidth-2)*0.5;
        double centerRectLength = (mapLengthPx/gridLength)*(gridWidth-2)*0.5;
        
        StdDraw.setPenColor(Main.BACKGROUND_COLOR);
        StdDraw.filledRectangle(centerX, centerY, centerRectWidth, centerRectLength);
        StdDraw.setPenColor(Main.TRACK_STROKE_COLOR);
        StdDraw.rectangle(centerX, centerY, centerRectWidth, centerRectLength);

        //StdDraw.line(5*laneWidth,10,10*laneWidth,10*laneWidth);
        //StdDraw.filledCircle(laneWidth, laneWidth, 1);
    }

}
