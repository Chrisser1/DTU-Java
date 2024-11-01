package Opgave3;
import java.awt.Color;

public class BoundingBox{
    boolean inclusive;
    int x1, y1, x1PxValue, y1PxValue;
    int x2, y2, x2PxValue, y2PxValue;

    public BoundingBox(int _x1, int _y1, int _x2, int _y2, boolean inclusive){
        this.x1 = _x1;
        this.y1 = _y1;
        this.x2 = _x2;
        this.y2 = _y2;
        this.x1PxValue = x1*Main.SQUARE_SIZE_PX;
        this.y1PxValue = y1*Main.SQUARE_SIZE_PX;
        this.x2PxValue = x2*Main.SQUARE_SIZE_PX;
        this.y2PxValue = y2*Main.SQUARE_SIZE_PX;
        this.inclusive = inclusive;
    }

    public boolean insideBound(int xPos, int yPos){
        if (xPos >= Math.min(this.x1,this.x2) && xPos <= Math.max(this.x1,this.x2) && yPos >= Math.min(this.y1,this.y2) && yPos <= Math.max(this.y1,this.y2)){
            return true;
        } else {
            return false;
        }
    }

    public boolean insideBoundPx(int xPos, int yPos){
        int xMin = Math.min(this.x1PxValue,this.x2PxValue);
        int xMax = Math.max(this.x1PxValue,this.x2PxValue);
        int yMin = Math.min(this.y1PxValue,this.y2PxValue);
        int yMax = Math.max(this.y1PxValue,this.y2PxValue);
        if (xPos >= xMin && xPos < xMax && yPos >= yMin && yPos < yMax){
            System.out.println("Inside box!");
            return true;
        } else {
            System.out.println("Not inside.. xPos: "+xPos+" yPos: "+yPos);
            System.out.println("xMin: "+xMin+" xMax: "+xMax);
            System.out.println("yMin: "+yMin+" yMax: "+yMax);
            return false;
        }
    }

    public void drawIfSelected(int xMouse, int yMouse, boolean overwrite){
        if (this.insideBoundPx(xMouse, yMouse)){
            this.display(Main.TRACK_COLOR);
        }
    }

    public void display(Color col){
        double boxWidth = Math.max(x1PxValue,x2PxValue)-Math.min(x1PxValue,x2PxValue);
        double boxLength = Math.max(y1PxValue,y2PxValue)-Math.min(y1PxValue,y2PxValue);
        double xBoxCenter = Math.max(x1PxValue,x2PxValue)-boxWidth/2;
        double yBoxCenter = Math.max(y1PxValue,y2PxValue)-boxLength/2;
        
        StdDraw.setPenColor(col);
        StdDraw.filledRectangle(xBoxCenter, yBoxCenter , boxWidth/2, boxLength/2);
    }
}