import java.util.Scanner;

public class Opgave5 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean isValidInput = false;
        double a = 0.0;
        double b = 0.0;
        double c = 0.0;

        while (!isValidInput) {
            a = getVariable(scanner, 'a');
            b = getVariable(scanner, 'b');
            c = getVariable(scanner, 'c');

            Double D = b * b - 4*a*c;
            if (D >= 0) {
                isValidInput = true;
            } else {
                System.out.println("Invalid input please input a valid a,b and c:");
            }

        }

        quadratic(a, b, c);
    }

    private static void  quadratic(double a, double b, double c) {
        if (a == 0) {
            System.out.println(b + "x + " + c + " = 0: x = " + -c/b);
        }
        double x_1 = (-b + Math.sqrt(b * b - 4*a*c))/(2*a);
        double x_2 = (-b - Math.sqrt(b * b - 4*a*c))/(2*a);

        if (x_1 == x_2) {
            System.out.println(a + "x^2" + b + "x + " + c + " = 0: x = " + x_1);
        } else {
            System.out.println(a + "x^2" + b + "x + " + c + " = 0: x_1 = " + x_1 + ", x_2 = " + x_2);
        }
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
