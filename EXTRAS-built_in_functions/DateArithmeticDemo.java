import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateArithmeticDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.print("Enter a date (yyyy-MM-dd): ");
        String inputDateStr = scanner.nextLine();

        try {
            LocalDate date = LocalDate.parse(inputDateStr, inputFormatter);

            // Add 7 days, 1 month, and 2 years
            LocalDate updatedDate = date.plusDays(7).plusMonths(1).plusYears(2);

            // Subtract 3 weeks
            updatedDate = updatedDate.minusWeeks(3);

            System.out.println("Original date: " + date.format(inputFormatter));
            System.out.println("After adding 7 days, 1 month, 2 years and subtracting 3 weeks: " + updatedDate.format(inputFormatter));
        } catch (Exception e) {
            System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
        } finally {
            scanner.close();
        }
    }
}
