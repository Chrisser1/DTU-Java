package Opgave3;
import java.util.ArrayList;

public class RaceTrack {
    private static final int DEFAULT_MARGIN = 10;
    private String premadeID = "new";
    private int gridWidth = 0; 
    private int gridLength = 0;
    private int mapWidthPx = 0;
    private int mapLengthPx = 0;
    private int xMarginPx = DEFAULT_MARGIN;
    private int yMarginPx = DEFAULT_MARGIN;

    private ArrayList<BoundingBox> inclusiveBoxes;
    private ArrayList<BoundingBox> exclusiveBoxes;
    private ArrayList<Button> buttons;

    private RaceTrack(int width, int length, String id){
        this.gridWidth = width;
        this.gridLength = length;
        this.premadeID = id;

        this.mapWidthPx = gridWidth*Main.SQUARE_SIZE_PX;
        this.mapLengthPx = gridLength*Main.SQUARE_SIZE_PX;

        this.inclusiveBoxes = new ArrayList<>();
        this.exclusiveBoxes = new ArrayList<>();
        this.buttons = new ArrayList<>();
        if (!premadeID.equals("new")){
            addBoundingBoxesFromID(premadeID);
        }
    }

    public static RaceTrack create(String premadeTrackID) {
        switch (premadeTrackID) {
            case "TrackChooser" -> {
                return new RaceTrack(20,20, premadeTrackID);
            }
            case "Square" -> {
                return new RaceTrack(10,10, premadeTrackID);
            }
            case "Lea" -> {
                return new RaceTrack(42,36, premadeTrackID);
            }
            case "new" -> {
                System.out.println("Created new track from scratch.");
                return new RaceTrack(10,10, premadeTrackID);
            }
            default -> {
                throw new IllegalArgumentException("Invalid track: " + premadeTrackID + ", created new empty track.");
            }   
        }
    }

    public void addBoundingBox(BoundingBox box, boolean inclusive){
        if (inclusive){
            this.inclusiveBoxes.add(box);
        } else {
            this.exclusiveBoxes.add(box);
        }
    }

    public void removeBoundingBox(int index, boolean inclusive){
        if (inclusive){
            this.inclusiveBoxes.remove(index);
        } else {
            this.exclusiveBoxes.remove(index);
        }
    }

    public void addBoundingBoxesFromID(String ID){
        switch (ID) {
            case "TrackChooser" -> {
                this.buttons.add(new Button(2, 2, 9, 9, "Square"));
                this.buttons.add(new Button(11, 11, 18, 18, "Lea"));
                this.buttons.add(new Button(2, 11, 9, 18, "new"));
                this.buttons.add(new Button(11, 2, 18, 9, "TrackChooser"));
            }
            case "Square" -> {
                
            }
            case "Lea" -> {
                this.inclusiveBoxes.add(new BoundingBox(10, 6, 33, 31, true));
                
            }
            default -> {
                throw new IllegalArgumentException("Encountered problem: Tried adding BoundingBoxes to " + ID + " which has no presets.");
            }   
        }
    }

    public void displayInclusiveBoundingBoxes(){
        for (BoundingBox box : this.inclusiveBoxes){
            box.display(Main.TRACK_COLOR);
        }
    }

    public void displayExclusiveBoundingBoxes(){
        for (BoundingBox box : this.exclusiveBoxes){
            box.display(Main.BACKGROUND_COLOR);
        }
    }

    public void displayAllBoundingBoxes(){
        this.displayInclusiveBoundingBoxes();
        this.displayExclusiveBoundingBoxes();
    }

    public ArrayList<BoundingBox> getInclusiveBoundingBoxes(){
        return this.inclusiveBoxes;
    }

    public void clearBoundingBoxes(){
        this.inclusiveBoxes = new ArrayList<>();
        this.exclusiveBoxes = new ArrayList<>();
    }

    public void initTrackFrame(){
        if (gridWidth != gridLength){
            int gridDifference = Math.max(gridWidth, gridLength)-Math.min(gridWidth, gridLength);
            if (gridWidth > gridLength){
                yMarginPx = DEFAULT_MARGIN + gridDifference*Main.SQUARE_SIZE_PX;
            } else {
                xMarginPx = DEFAULT_MARGIN + gridDifference*Main.SQUARE_SIZE_PX;
            }
        }
        StdDraw.setXscale(-xMarginPx,mapWidthPx+xMarginPx);
        StdDraw.setYscale(-yMarginPx,mapLengthPx+yMarginPx);
    }

    public void displayGrid(){
        StdDraw.setPenColor(Main.GRID_DOT_COLOR);
        for (int row = 0; row <= gridWidth; row++){
            for (int column = 0; column <= gridLength; column++){ 
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

    public int getMaxMargin(){
        return Math.max(this.xMarginPx, this.yMarginPx);
    }

    public int getMapWidthPx(){
        return this.mapWidthPx;
    }

    public int getMapLengthPx(){
        return this.mapWidthPx;
    }

    public void addButton(Button button){
        this.buttons.add(button);
    }

    public ArrayList<Button> getButtons(){
        return this.buttons;
    }
}
