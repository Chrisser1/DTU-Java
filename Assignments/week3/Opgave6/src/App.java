import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        double a = getVariable(scanner, 'a');
        double b = getVariable(scanner, 'b');
        double c = getVariable(scanner, 'c');

        quadratic(a, b, c);
    }

    private static void quadratic(double a, double b, double c) {
        double x_1 = (-b + Math.sqrt(b * b - 4*a*c))/(2*a);
        double x_2 = (-b - Math.sqrt(b * b - 4*a*c))/(2*a);

        System.out.println(a + "x^2" + b + "x" + c + " = 0: x_1 = " + x_1 + ", x_2 = " + x_2);
    }

    private static double getVariable(Scanner scanner, char variable) {
        double number;
        while (true) {
            System.out.print("Please enter " + variable + ": ");
            if (scanner.hasNextDouble()) {
                number = scanner.nextDouble();
                break;  // Exit loop if input is valid
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }
        return number;
    }
}
