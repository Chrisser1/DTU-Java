package Opgave3;
import java.awt.Color;

public class Button extends BoundingBox {
    private static final Color BUTTON_COLOR = new Color(50,50,50);
    private static final Color BUTTON_HOVERED = new Color(75,75,75);
    private String ID;
    private boolean isPressed;

    public Button(int x1, int y1, int x2, int y2, String id){
        super(x1, y1, x2, y2, true);
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

    public void setPressedStatus(boolean newState){
        this.isPressed = newState;
    }

    public boolean getPressedStatus(){
        return isPressed;
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
}
