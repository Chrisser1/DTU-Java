public class App {
    public static void main(String[] args) throws Exception {
        printCones();
        printCubesSameLine();
        printUSA();
        printCubesSameLine();
        printCones();
    }

    public static void printCones() {
        System.out.println("   /\\          /\\");
        System.out.println("  /  \\        /  \\");
        System.out.println(" /    \\      /    \\");
    }

    public static void printCubesSameLine() {
        printCubeTopBottom();
        printLine();
        printLine();
        printCubeTopBottom();
    }

    public static void printCubeTopBottom(){
        System.out.println("+------+    +------+");
    }

    public static void printLine() {
        System.out.println("|      |    |      |");
    }

    public static void printUSA() {
        System.out.println("|United|    |United|");
        System.out.println("|States|    |States|");
        System.out.println("|Denmar|    |kkkkkk|");
        System.out.println("|IsMuch|    |Better|");
    }
}
