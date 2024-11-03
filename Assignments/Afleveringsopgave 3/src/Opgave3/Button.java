package Opgave3;
import java.awt.Color;
import java.awt.Font;
import java.awt.TrayIcon.MessageType;

import javax.swing.JOptionPane;

public class Button extends BoundingBox {
    private static final Color BUTTON_COLOR = new Color(50,50,50);
    private static final Color BUTTON_HOVERED = new Color(75,75,75);
    private String ID;
    private RaceTrack inTrack;
    private boolean isPressed;
    private boolean recentlyHovered;

    public Button(int x1, int y1, int x2, int y2, String id, RaceTrack track){
        super(x1, y1, x2, y2, true);
        this.inTrack = track;
        this.ID = id;
        this.isPressed = false;
    }

    public boolean isHovered(int xMouse, int yMouse){
        if (this.insideBoundPx(xMouse, yMouse)){
            return true;
        } else {
            return false;
        }
    }

    public String getID(){
        return this.ID;
    }

    public static Button getButton(RaceTrack track, String id){
        for (Button button : track.getButtons()){
            if (button.getID().equals(id)){
                return button;
            }
        }
        return null;
    }

    public void setPressedStatus(boolean newState){
        this.isPressed = newState;
    }

    public boolean getPressedStatus(){
        return isPressed;
    }

    @Override
    public void display(Color color){
        super.display(color);
        // Calculates points for middle of button
        double xDifference = Math.max(x1,x2)-Math.min(x1,x2);
        double yDifference = Math.max(y1,y2)-Math.min(y1,y2);
        double xCenter = Math.min(x1,x2) + (xDifference*0.5);
        double yCenter = Math.min(y1,y2) + (yDifference*0.5);
        Font font = new Font("Arial", Font.BOLD, (int) xDifference*4); // "Arial" with bold style
        StdDraw.setFont(font);
        StdDraw.setPenColor(Main.BACKGROUND_COLOR);
        StdDraw.text(xCenter*Main.SQUARE_SIZE_PX, yCenter*Main.SQUARE_SIZE_PX, ID);
    }

    public void updateDisplay(int xMouse, int yMouse){
        if (isPressed){
            super.display(Main.TRACK_STROKE_COLOR);
        } else if (this.isHovered(xMouse, yMouse)){
            this.display(BUTTON_HOVERED);
        } else {
            this.display(BUTTON_COLOR);
        }
    }

    public void updateDisplay(){
        updateDisplay(0, 0);
    }

    // Kører funktionen af den knap der er trykket
    public void runPressAction(){
        if (this.inTrack.getID().equals("TrackChooser")){
            // Finder det raceTrack der har den trykkede knap's ID
            Main.selectTrack(Main.getTrackFromID(this.ID));    
            
        } else {
            Car currentCar = inTrack.getSelectedCar();
            switch (this.ID){
                case ("new") -> {
                    Main.selectTrack(Main.getTrackFromID("TrackBuilder"));
                }
                case ("1") -> {
                    currentCar.setXVel(currentCar.getXVel()-1);
                    currentCar.setYVel(currentCar.getYVel()-1);
                }
                case ("2") -> {
                    currentCar.setYVel(currentCar.getYVel()-1);
                }
                case ("3") -> {
                    currentCar.setXVel(currentCar.getXVel()+1);
                    currentCar.setYVel(currentCar.getYVel()-1);
                }
                case ("4") -> {
                    currentCar.setXVel(currentCar.getXVel()-1);
                }
                case ("5") -> {
                    
                }
                case ("6") -> {
                    currentCar.setXVel(currentCar.getXVel()+1);
                }
                case ("7") -> {
                    currentCar.setXVel(currentCar.getXVel()-1);
                    currentCar.setYVel(currentCar.getYVel()+1);
                }
                case ("8") -> {
                    currentCar.setYVel(currentCar.getYVel()+1);
                }
                case ("9") -> {
                    currentCar.setXVel(currentCar.getXVel()+1);
                    currentCar.setYVel(currentCar.getYVel()+1);
                }
                default -> {
                    System.out.println("Pressed button: "+this.ID+" (no action defined)");
                }
            }
            if (!this.ID.equals("new")){
                currentCar.move();
                currentCar.drawLastMove();
                boolean endGame = false;
                String message = "";
                if (currentCar.hasCrashed()){
                    message = currentCar.getName()+" crashed and lost.";
                    endGame = true;
                } else if (currentCar.hasFinished()){
                    message = currentCar.getName()+" won the game.";
                    endGame = true;
                }
                if (endGame){
                    JOptionPane.showMessageDialog(null,message);
                    Main.selectTrack(Main.getTrackFromID("TrackChooser"));
                    currentCar.reset();
                }
            }
        }
    }

    public boolean recentlyHovered(){
        return this.recentlyHovered;
    }

    public void setRecentlyHovered(boolean newStatus){
        this.recentlyHovered = newStatus;
    }
}
