import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.print("Enter the first date (yyyy-MM-dd): ");
        String firstDateStr = scanner.nextLine();

        System.out.print("Enter the second date (yyyy-MM-dd): ");
        String secondDateStr = scanner.nextLine();

        try {
            LocalDate firstDate = LocalDate.parse(firstDateStr, inputFormatter);
            LocalDate secondDate = LocalDate.parse(secondDateStr, inputFormatter);

            if (firstDate.isBefore(secondDate)) {
                System.out.println("The first date is before the second date.");
            } else if (firstDate.isAfter(secondDate)) {
                System.out.println("The first date is after the second date.");
            } else if (firstDate.isEqual(secondDate)) {
                System.out.println("Both dates are the same.");
            }
        } catch (Exception e) {
            System.out.println("Invalid date format. Please enter dates in yyyy-MM-dd format.");
        } finally {
            scanner.close();
        }
    }
}
