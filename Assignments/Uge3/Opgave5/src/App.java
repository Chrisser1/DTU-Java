import java.text.DecimalFormat;

public class App {
    public static void main(String[] args) throws Exception {
        printTable(2003, 6.5, 1000, 100, 25);
    }

    private static void printTable(int starting_year, double rate, double starting_amount, double input_pr_year, int years) {
        int width = 10; // Adjust column width here for better alignment
        printHeader(width);

        int year = starting_year;
        double amount = starting_amount;
        DecimalFormat df = new DecimalFormat("#.00"); // Decimal format for consistent 2 decimal places

        for (int i = 0; i < years; i++) {
            double input = i == 0 ? starting_amount : input_pr_year;

            // Use formatted strings for better control over alignment
            System.out.printf("%-" + width + "d%-" + width + "s%-" + width + "s%-" + width + "s%n",
                    year,
                    df.format(rate) + "%",
                    "$" + df.format(input),
                    "$" + df.format(amount));

            // Update the amount for the next year
            amount = amount * (1 + rate / 100) + input_pr_year; // Assuming rate is a percentage growth
            year++;
        }
    }

    private static void printHeader(int width) {
        // Header with consistent alignment
        System.out.printf("%-" + width + "s%-" + width + "s%-" + width + "s%-" + width + "s%n",
                "Year", "Rate", "Inputted", "Value");
    }
}
