package Opgave4;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Color;
public class GameOfLifeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        File stateFile = getUserInit(scanner);

        GameOfLife gameOfLife = makeFromFile(stateFile);
        int gridSize = gameOfLife.gameState.length;
        int periodicLength = 2000;
        int[] states = new int[periodicLength];
        int n = 20;

        // Set the canvas size and scale
        StdDraw.setCanvasSize(500, 500);
        StdDraw.setScale(0, gridSize);
        StdDraw.setYscale(gridSize, 0); // Invert y-axis

        int i = 0;
        boolean periodic = false;
        while (!periodic) {
            // Clear the previous frame
            StdDraw.clear();
            // Save the state in the state list
            states[i % periodicLength] = gameOfLife.getUniqueState();
            // If we have a duplicate set periodic to true
            if (containsDuplicate(states)) {
                periodic = true;
            }

            // Draw the game state
            drawGrid(gameOfLife, periodic);
            StdDraw.show(n);

            gameOfLife.nextState();
            i++;
        }
    }

    private static File getUserInit(Scanner scanner) {
        File folder = new File("Assignments\\Afleveringsopgave 3\\src\\Opgave4\\states");
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles == null || listOfFiles.length == 0) {
            System.out.println("No state files found in the 'states' folder.");
            System.exit(1);
        }

        System.out.println("Please select one of the following initial states:");
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println((i + 1) + ": " + listOfFiles[i].getName());
            }
        }

        int choice = -1;
        while (choice < 1 || choice > listOfFiles.length) {
            System.out.print("Enter the number of your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice < 1 || choice > listOfFiles.length) {
                    System.out.println("Invalid choice. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
            }
        }

        return listOfFiles[choice - 1];
    }

    private static GameOfLife makeFromFile(File file) {
        // Init a empty starting state
        ArrayList<int[]> tempState = new ArrayList<>();
        int length = 0;

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                // get the individual tokens in the String where there is a space (line)
                String[] tokens = line.trim().split("\\s+");
                // init a row to hold the values
                int[] row = new int[tokens.length];

                if (tokens.length > length) {
                    length = tokens.length;
                }

                // add the values to row
                for (int x = 0; x < tokens.length; x++) {
                    row[x] = Integer.parseInt(tokens[x]);
                }
                // add the row to the temporary state
                tempState.add(row);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            System.exit(1);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in the file: " + e.getMessage());
            System.exit(1);
        }

        // init the final grid
        int[][] gameState = new int[length][length];

        // Copy the pattern into the game state array
        for (int y = 0; y < length; y++) {
            int[] row = tempState.get(y);
            for (int x = 0; x < length; x++) {
                gameState[x][y] = row[x];
            }
        }

        return new GameOfLife(gameState);
    }


    private static void drawGrid(GameOfLife gameOfLife, boolean periodic) {
        int lengthX = gameOfLife.gameState.length;
        int lengthY = gameOfLife.gameState[0].length;

        for (int x = 0; x < lengthX; x++) {
            for (int y = 0; y < lengthY; y++) {
                if (gameOfLife.gameState[x][y] > 0) {
                    StdDraw.setPenColor(getCellColor(gameOfLife.gameState[x][y]));
                    StdDraw.filledSquare(x + 0.5, y + 0.5, 0.5);
                }
            }
        }

        if (periodic) {
            StdDraw.setPenColor(Color.RED);
            StdDraw.text(lengthX/2, lengthY/2, "A periodic loop was detected");
        }
    }

    private static Color getCellColor(int cellState) {
        switch (cellState) {
            case 1:
                return Color.BLACK;
            case 2:
                return Color.BLUE;
            case 3:
                return Color.RED;
            case 4:
                return Color.GREEN;
            default:
                return Color.PINK;
        }
    }

    public static boolean containsDuplicate(int[] list) {
        for (int i = 0; i < list.length; i++) {
            for (int j = i + 1; j < list.length; j++) {
                if (list[i] == list[j] && (list[i] != 0 && list[j] != 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}
