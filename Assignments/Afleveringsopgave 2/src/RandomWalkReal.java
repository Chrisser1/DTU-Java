import java.util.Random;
import java.util.Scanner;

public class RandomWalkReal {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        StdDraw.setCanvasSize(800,800);
        System.out.println("Input the grid size as a whole number: ");
        //Creating grid with size the user inputs as a integer
        int gridSize = console.nextInt();
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
}