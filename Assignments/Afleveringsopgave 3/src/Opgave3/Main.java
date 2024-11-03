package Opgave3;
import java.awt.Color;
import java.awt.TrayIcon.MessageType;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main{
    public static final int WIDTH = 1500;
    public static final int LENGTH = 1000;
    public static final int SQUARE_SIZE_PX = 5;
    public static final Color BACKGROUND_COLOR = new Color(100,130,150);
    public static final Color TRACK_COLOR = new Color(200,230,250);
    public static final Color TRACK_STROKE_COLOR = new Color(50,130,130);
    public static final Color GRID_DOT_COLOR = new Color(0,0,0);
    public static final String[] PREMADE_TRACK_IDS = {"Square", "LShape", "Turns", "TrackChooser", "TrackBuilder"};
    public static final String[] SIZE_REQUIRED_TRACK_IDS = {"Square", "TrackBuilder"};
    private static ArrayList<RaceTrack> raceTracks = new ArrayList<>();
    private static RaceTrack selectedTrack;

    public static void main(String[] args) {
        StdDraw.setCanvasSize(WIDTH,LENGTH);
        initTracks(SIZE_REQUIRED_TRACK_IDS, true);
        initTracks(PREMADE_TRACK_IDS, false);
        selectTrack(getTrackFromID("TrackChooser"));
        
        while (true) { // Continuous loop running the program
            selectedTrack.getSelectedCar().draw();

            int xMouse = (int) StdDraw.mouseX();
            int yMouse = (int) StdDraw.mouseY();
            for (Button button : selectedTrack.getButtons()){
                if (button.isHovered(xMouse, yMouse)){
                    button.updateDisplay(xMouse, yMouse);
                    button.setRecentlyHovered(true);
                } else if (button.recentlyHovered()){
                    button.updateDisplay(xMouse, yMouse);
                    button.setRecentlyHovered(false);
                }
            }
            if (StdDraw.mousePressed()){
                // Check if a button is hovered, and if yes, then saves which button
                String hoveredOnPress = "null";
                for (Button button : selectedTrack.getButtons()){
                    if (button.isHovered(xMouse, yMouse)){
                        button.setPressedStatus(true);
                        button.updateDisplay();
                        hoveredOnPress = button.getID();
                        break;
                    }
                }
                while (StdDraw.mousePressed()){
                    // Wait for mouse to be released
                }
                if (hoveredOnPress != "null"){
                    // Check if a button is hovered, and if yes, then checks if it's the same after mouse release as on mouse press
                    xMouse = (int) StdDraw.mouseX();
                    yMouse = (int) StdDraw.mouseY();
                    String hoveredOnRelease = "null";
                    for (Button button : selectedTrack.getButtons()){ // For-loop checks for button mouse range
                        if (button.isHovered(xMouse, yMouse)){
                            hoveredOnRelease = button.getID();
                            break;
                        }
                    } 
                    Button pressedButton = Button.getButton(selectedTrack, hoveredOnPress);
                    if (hoveredOnPress.equals(hoveredOnRelease)){
                        pressedButton.runPressAction();
                    }
                    if (selectedTrack.getButtons().contains(pressedButton)){
                        pressedButton.setPressedStatus(false);
                        pressedButton.updateDisplay();
                    }
                }
            }
        }
    }

    public static int getValidInt(int min, int max, String message) {
        String prompt;
        if (message.equals("")){
            prompt ="Enter an integer in the interval ["+min+","+max+"]:";
        } else {
            prompt = message;
        }
        int recievedInt = min-1;
        boolean validInput = false;
        boolean notAnInt = false;
        while (!validInput) {
            try {
                recievedInt = Integer.parseInt(JOptionPane.showInputDialog(prompt, MessageType.INFO));
            } catch(Exception e) {
                prompt = "Invalid input - not an integer. Please enter an integer in the interval ["+min+","+max+"]:";
                notAnInt = true;
            }
            if (!notAnInt){
                if (recievedInt >= min && recievedInt <= max) {
                    validInput = true;
                } else {
                    prompt = "Input must be in the interval ["+min+","+max+"], try again:";
                }
            }
            notAnInt = false;
        }
        return recievedInt;
    }

    private static void resetBackground(){
        StdDraw.setPenColor(BACKGROUND_COLOR);
        StdDraw.filledSquare(selectedTrack.getMapWidthPx()/2, selectedTrack.getMapLengthPx()/2, selectedTrack.getMaxMargin()+Math.max(selectedTrack.getMapLengthPx(),selectedTrack.getMapWidthPx())+100);
    }

    private static void initTracks(String[] ids, boolean takesCustomSizes){
        for (String s : ids){
            initTrack(s, takesCustomSizes);
        }
    }

    private static void initTrack(String id, boolean takesCustomSize){
        for (RaceTrack track : raceTracks){
            if (track.getID().equals(id)){
                System.out.println("IGNORING: Tried initialising existing track: "+id);
                return;
            }
        }
        RaceTrack newTrack = RaceTrack.create(id, takesCustomSize);
        raceTracks.add(newTrack);
    }

    public static void selectTrack(RaceTrack track){
        if (selectedTrack == track){
            System.out.println(track.getID()+" is already selected - keeping it.");
        } else {
            System.out.println("Selecting track: "+track.getID());
            selectedTrack = track;
        }
        if (selectedTrack.requiresCustomSize()){
            int customWidth;
            int customLength;
            switch (selectedTrack.getID()) {
                case "Square" ->{
                    customWidth = getValidInt(10, 20, "Angiv størrelse på track i intervallet [10,20]:");
                    customLength = customWidth;
                    break;
                }
                case "TrackBuilder" ->{
                    customWidth = (getValidInt(4, 50, "Angiv bredde på track i intervallet [4,50]:"));
                    customLength = (getValidInt(4, 50, "Angiv længde på track i intervallet [4,50]:"));
                }
                default -> {
                    customWidth = (getValidInt(4, 20, "Angiv bredde på track i intervallet [4,20]:"));
                    customLength = (getValidInt(4, 20, "Angiv bredde på track i intervallet [4,20]:"));
                }
            }
            selectedTrack.setGridWidth(customWidth);
            selectedTrack.setGridLength(customLength);
        }

        selectedTrack.addBoundingBoxesFromID(selectedTrack.getID());
        selectedTrack.addControlPanelButtons();
        selectedTrack.initTrackFrame();
        resetBackground();
        selectedTrack.displayAllBoundingBoxes();
        selectedTrack.displayGrid();
        selectedTrack.drawFinishLine();
        for (Button button : selectedTrack.getButtons()){
            button.updateDisplay();
        }
    }

    public static ArrayList<RaceTrack> getRaceTracks(){
        return raceTracks;
    }

    
    public static RaceTrack getTrackFromID(String id){
        for (RaceTrack track : raceTracks){
            if (track.getID().equals(id)){
                return track;
            }
        }
        System.out.println("WARNING: Used getTrackFromID(\""+id+"\"), but no track with that ID existed. Created new track: "+id);
        return RaceTrack.create(id, true);
    }
}