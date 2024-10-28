public class App {
    static final int STEPS = 10;

    public static void main(String[] args) throws Exception {
        for (int i = 1; i <= STEPS; i++) {
            printHead(i);
            printBody(i);
            printFeet(i);
        }
        printBottom(STEPS);
    }

    private static int spacesBefore(int currentStep){
        return (STEPS-currentStep)*5;
    }

    private static int spacesAfter(int currentStep){
        return currentStep*5;
    }

    private static void printHead(int step){
        for (int i = 1; i <= spacesBefore(step); i++){
            System.out.print(" ");
        }
        System.out.print("  o  ******");
        for (int i = 1; i <= spacesAfter(step-1); i++){
            System.out.print(" ");
        }
        System.out.println("*");
    }

    private static void printBody(int step){
        for (int i = 1; i <= spacesBefore(step); i++){
            System.out.print(" ");
        }
        System.out.print(" /|\\ *");
        for (int i = 1; i <= spacesAfter(step); i++){
            System.out.print(" ");
        }
        System.out.println("*");
    }

    private static void printFeet(int step){
        for (int i = 1; i <= spacesBefore(step); i++){
            System.out.print(" ");
        }
        System.out.print(" / \\ *");
        for (int i = 1; i <= spacesAfter(step); i++){
            System.out.print(" ");
        }
        System.out.println("*");
    }
    private static void printBottom(int stepammount){
        for (int i = 1; i <= stepammount; i++){
            System.out.print("*****");
        }
        System.out.println("*******");
    }
}
