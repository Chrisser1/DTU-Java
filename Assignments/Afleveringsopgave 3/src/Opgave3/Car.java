package Opgave3;

import java.awt.Color;

public class Car {
    private int xPos;
    private int yPos;
    private int xVel;
    private int yVel;
    private String name;
    private static RaceTrack inTrack;
    private static final Color CAR_COLOR = new Color(200,100,100);

    public Car(int initialXPos, int initialYPos, String nameOfPlayer, RaceTrack track){
        this.name = nameOfPlayer;
        this.xPos = initialXPos;
        this.yPos = initialYPos;
        inTrack = track;
    }

    public void move(){
        xPos+=xVel;
        yPos+=yVel;
    }

    public void draw(){
        StdDraw.setPenColor(CAR_COLOR);
        StdDraw.filledCircle(xPos*Main.SQUARE_SIZE_PX, yPos*Main.SQUARE_SIZE_PX, 0.2);
    }

    public void drawLastMove(){
        StdDraw.setPenColor(CAR_COLOR);
        StdDraw.line(xPos*Main.SQUARE_SIZE_PX, yPos*Main.SQUARE_SIZE_PX, (xPos-xVel)*Main.SQUARE_SIZE_PX, (yPos-yVel)*Main.SQUARE_SIZE_PX);
    }

    public int getXPos(){
        return this.xPos;
    }

    public void setXPos(int newXPos){
        this.xPos = newXPos;
    }

    public int getYPos(){
        return this.yPos;
    }

    public void setYPos(int newYPos){
        this.yPos = newYPos;
    }

    public int getXVel(){
        return this.xVel;
    }

    public void setXVel(int newXVel){
        this.xVel = newXVel;
    }

    public int getYVel(){
        return this.yVel;
    }

    public void setYVel(int newYVel){
        this.yVel = newYVel;
    }

    public RaceTrack getTrack(){
        return inTrack;
    }

    public boolean hasFinished(){
        if (xPos == 10){
            return true;
        } else {
            return false;
        }
        // Logik baseret på inTrack
    }

    public boolean hasCrashed(){
        boolean crash = false;
        for (BoundingBox box : inTrack.getInclusiveBoundingBoxes()){
            System.out.println("Box: "+box.toString());
            if (box.insideBound(xPos, yPos)){
                crash = false;
            }
        }
        for (BoundingBox box : inTrack.getExclusiveBoundingBoxes()){
            if (box.insideBound(xPos, yPos)){
                crash = true;
            }
        }
        return crash;
    }

    public String getName(){
        return this.name;
    }

    public void reset(){
        this.xPos = inTrack.getX1Finish();
        this.yPos = inTrack.getY1Finish();
        this.xVel = 0;
        this.yVel = 0;
    }
}
