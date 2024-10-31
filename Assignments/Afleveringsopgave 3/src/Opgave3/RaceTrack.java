import java.awt.Color;

public class RaceTrack {
    private int width, length;
    private ArrayList<BoundingBox> inclusiveBoxes;
    private ArrayList<BoundingBox> exclusiveBoxes;

    public RaceTrack(int _width, int _length){
        width = _width;
        length = _length;

    }
    
    
    private static void draw(int laneWidth){
        draw(laneWidth, 4, 4);
    }

    private static void draw(int laneWidth, int trackWidth, int trackLength){
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

}
