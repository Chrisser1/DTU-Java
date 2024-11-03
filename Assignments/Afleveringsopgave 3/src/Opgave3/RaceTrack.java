package Opgave3;
import java.util.ArrayList;
import java.awt.Color;

public class RaceTrack {
    private static final Color FINISH_LINE_COLOR = new Color(100,200,100);
    private static final int DEFAULT_MARGIN = 10;
    private String id = "new";

    private int gridWidth = 0; 
    private int gridLength = 0;
    private int mapWidthPx = 0;
    private int mapLengthPx = 0;

    private int x1Finish, y1Finish, x2Finish, y2Finish;

    private int xMarginPx = DEFAULT_MARGIN;
    private int yMarginPx = DEFAULT_MARGIN;

    private ArrayList<BoundingBox> inclusiveBoxes;
    private ArrayList<BoundingBox> exclusiveBoxes;
    private ArrayList<Button> buttons;
    private boolean requiresCustomSize;

    private static ArrayList<Car> trackCars = new ArrayList<>();
    private Car selectedCar;

    private RaceTrack(int width, int length, String inputId, boolean customSized){
        this.gridWidth = width;
        this.gridLength = length;
        this.id = inputId;

        this.mapWidthPx = gridWidth*Main.SQUARE_SIZE_PX;
        this.mapLengthPx = gridLength*Main.SQUARE_SIZE_PX;

        this.inclusiveBoxes = new ArrayList<>();
        this.exclusiveBoxes = new ArrayList<>();
        this.buttons = new ArrayList<>();

        this.requiresCustomSize = customSized;

        switch (inputId){
            case "TrackChooser" -> {
            }
            case "Square" -> {
                x1Finish = gridWidth/2;
                y1Finish = 0;
                x2Finish = gridWidth/2;
                y2Finish = gridLength/4;
            }
            case "LShape" -> {
                x1Finish = gridWidth/2;
                y1Finish = 0;
                x2Finish = gridWidth/2;
                y2Finish = 2;
            }
            case "Turns" -> {
                x1Finish = gridWidth/2;
                y1Finish = 0;
                x2Finish = gridWidth/2;
                y2Finish = 2;
            }
            default -> {
                System.out.println("New track - Defaulted finish line.");
                x1Finish = 1;
                y1Finish = 1;
                x2Finish = 2;
                y2Finish = 1;
            }  
        }

        Car car = new Car(x1Finish,y1Finish+1, "Player", this);
        trackCars.add(car);
        this.selectedCar = car;
    }

    public static RaceTrack create(String premadeTrackID, boolean customSized) {
        switch (premadeTrackID) {
            case "TrackChooser" -> {
                return new RaceTrack(20,20, premadeTrackID, customSized);
            }
            case "TrackBuilder" -> {
                return new RaceTrack(1,1, premadeTrackID, customSized);
            }
            case "Square" -> {
                return new RaceTrack(1,1, premadeTrackID, customSized);
            }
            case "LShape" -> {
                return new RaceTrack(12,20, premadeTrackID, customSized);
            }
            case "Turns" -> {
                return new RaceTrack(38,30, premadeTrackID, customSized);
            }
            default -> {
                System.out.println("Created new track with ID:" + premadeTrackID);
                return new RaceTrack(1,1, premadeTrackID, customSized);
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
                this.buttons.add(new Button(2, 2, 9, 9, "Turns", this));
                this.buttons.add(new Button(11, 11, 18, 18, "LShape", this));
                this.buttons.add(new Button(2, 11, 9, 18, "Square", this));
                this.buttons.add(new Button(11, 2, 18, 9, "new", this));
            }
            case "TrackBuilder" -> {

            }
            case "new" -> {

            }
            case "Square" -> {
                this.inclusiveBoxes.add(new BoundingBox(0, 0, gridWidth, gridLength, true));
                int x = gridWidth/4;
                int y = gridLength/4;
                if (gridWidth % 4 != 0){
                    x++;
                }
                if (gridLength % 4 != 0){
                    y++;
                }
                this.exclusiveBoxes.add(new BoundingBox(x, y, gridWidth-x, gridLength-y, false));
            }
            case "LShape" -> {
                this.inclusiveBoxes.add(new BoundingBox(0, 0, gridWidth, 5, true));
                this.inclusiveBoxes.add(new BoundingBox(0, 5, 5, gridLength, true));

                this.exclusiveBoxes.add(new BoundingBox(2, 2, gridWidth-2, 3, false));
                this.exclusiveBoxes.add(new BoundingBox(2, 3, 3, gridLength-2, false));
            }
            case "Turns" -> {
                this.inclusiveBoxes.add(new BoundingBox(0, 0, gridWidth, gridLength, true));

                for (int i = 2; i < gridWidth-2; i = i+8){
                    this.exclusiveBoxes.add(new BoundingBox(i, 4, i+2, gridLength-2, false));
                    this.exclusiveBoxes.add(new BoundingBox(i+4, 6, i+6, gridLength, false));
                }
                this.exclusiveBoxes.add(new BoundingBox(2, 2, gridWidth-2, 4, false));
                
            }
            default -> {
                throw new IllegalArgumentException("Encountered problem: Tried adding BoundingBoxes to " + ID + " which has no presets.");
            }   
        }
    }

    public void addControlPanelButtons(){
        if (!this.id.equals("TrackChooser") && !this.id.equals("TrackBuilder")){
            int panelXStart = gridWidth+2;
            int panelLengthMidPoint = gridLength/2;
            int buttonSize = 1;
            int spacing = 1;
            this.buttons.add(new Button(panelXStart, panelLengthMidPoint, panelXStart+buttonSize, panelLengthMidPoint+buttonSize, "1", this));
            this.buttons.add(new Button(panelXStart+buttonSize+spacing, panelLengthMidPoint, panelXStart+buttonSize*2+spacing, panelLengthMidPoint+buttonSize, "2", this));
            this.buttons.add(new Button(panelXStart+buttonSize*2+spacing*2, panelLengthMidPoint, panelXStart+buttonSize*3+spacing*2, panelLengthMidPoint+buttonSize, "3", this));
            this.buttons.add(new Button(panelXStart, panelLengthMidPoint+buttonSize+spacing, panelXStart+buttonSize, panelLengthMidPoint+buttonSize*2+spacing, "4", this));
            this.buttons.add(new Button(panelXStart+buttonSize+spacing, panelLengthMidPoint+buttonSize+spacing, panelXStart+buttonSize*2+spacing, panelLengthMidPoint+buttonSize*2+spacing, "5", this));
            this.buttons.add(new Button(panelXStart+buttonSize*2+spacing*2, panelLengthMidPoint+buttonSize+spacing, panelXStart+buttonSize*3+spacing*2, panelLengthMidPoint+buttonSize*2+spacing, "6", this));
            this.buttons.add(new Button(panelXStart, panelLengthMidPoint+buttonSize*2+spacing*2, panelXStart+buttonSize, panelLengthMidPoint+buttonSize*3+spacing*2, "7", this));
            this.buttons.add(new Button(panelXStart+buttonSize+spacing, panelLengthMidPoint+buttonSize*2+spacing*2, panelXStart+buttonSize*2+spacing, panelLengthMidPoint+buttonSize*3+spacing*2, "8", this));
            this.buttons.add(new Button(panelXStart+buttonSize*2+spacing*2, panelLengthMidPoint+buttonSize*2+spacing*2, panelXStart+buttonSize*3+spacing*2, panelLengthMidPoint+buttonSize*3+spacing*2, "9", this));
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

    public ArrayList<BoundingBox> getExclusiveBoundingBoxes(){
        return this.exclusiveBoxes;
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
        int controlPanelSize = (xMarginPx+mapWidthPx)/2;
        StdDraw.setXscale(-xMarginPx,mapWidthPx+xMarginPx+controlPanelSize);
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

    public String getID(){
        return this.id;
    }

    public boolean requiresCustomSize(){
        return this.requiresCustomSize;
    }

    public void setGridWidth(int xValue){
        this.gridWidth = xValue;
        this.mapWidthPx = gridWidth*Main.SQUARE_SIZE_PX;
    }

    public void setGridLength(int yValue){
        this.gridLength = yValue;
        this.mapLengthPx = gridLength*Main.SQUARE_SIZE_PX;
    }

    public Car getSelectedCar(){
        return this.selectedCar;
    }

    public void drawFinishLine(){
        StdDraw.setPenColor(FINISH_LINE_COLOR);
        StdDraw.line(x1Finish*Main.SQUARE_SIZE_PX, y1Finish*Main.SQUARE_SIZE_PX, x2Finish*Main.SQUARE_SIZE_PX, y2Finish*Main.SQUARE_SIZE_PX);
    }

    public int getX1Finish(){
        return this.x1Finish;
    }
    public int getY1Finish(){
        return this.y1Finish;
    }
}
