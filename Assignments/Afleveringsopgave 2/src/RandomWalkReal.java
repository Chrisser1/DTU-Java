import java.util.Random;
import java.util.Scanner;

public class RandomWalkReal {
    public static void main(String[] args) {
        // Setting the canvas size
        StdDraw.setCanvasSize(800,800);
        
        //Creating grid with size the user inputs as a integer
        System.out.println("Input the grid size as a whole positive number: ");
        int gridSize = getNumber();
        System.out.println(gridSize);
        createGrid(gridSize);
        //Creating a random object
        Random random = new Random();
        
        int x = 0;
        int y = 0;
        //The while loop is alwas true aslong as out coordinates is not 
        while(x < gridSize && x > -gridSize && y < gridSize && y > -gridSize) {
            draw(x, y);
            double randomNumber = random.nextDouble();
            
            if (randomNumber < 0.25){
                x++;
            }else if(randomNumber < 0.5){
                x--;
            }else if(randomNumber < 0.75){
                y++;
            }else{
                y--;
            }
        }
    }
    //Creating the grid
    public static void createGrid(int n) {
        StdDraw.setXscale(-n, n);
        StdDraw.setYscale(-n, n);
    }
    //Creating the grid
    public static void draw(int x, int y) {
        StdDraw.filledCircle(x, y, 0.5);
    }
    public static int getNumber(){
        Scanner console = new Scanner(System.in);
        int x = 0;
        boolean isTrue = false;

        while (!isTrue){
            try {
                x = Integer.parseInt(console.nextLine());
                isTrue = true;
                if (x < 0) {
                    x *= -1;
                }
            } catch (Exception e) {
                System.out.println("Error: input was not a whole number");
            }
        }
        return x;
    }
}