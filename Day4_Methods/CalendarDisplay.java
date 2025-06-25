package Day4_Methods;

import java.util.Scanner;

public class CalendarDisplay {

    private static final String[] months = {
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    };

    private static final int[] daysInMonth = {
        31, 28, 31, 30, 31, 30,
        31, 31, 30, 31, 30, 31
    };

    public static String getMonthName(int month) {
        if (month < 1 || month > 12) {
            return "Invalid Month";
        }
        return months[month - 1];
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        return year % 4 == 0;
    }

    public static int getNumberOfDays(int month, int year) {
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return daysInMonth[month - 1];
    }

    public static int getFirstDayOfMonth(int month, int year) {
        int m = month;
        int y = year;
        if (m < 3) {
            m += 12;
            y -= 1;
        }
        int k = y % 100;
        int j = y / 100;
        int d = 1;
        int f = d + (13 * (m + 1)) / 5 + k + (k / 4) + (j / 4) + 5 * j;
        int dayOfWeek = f % 7;
        
        dayOfWeek = (dayOfWeek + 6) % 7;
        return dayOfWeek;
    }

    public static void displayCalendar(int month, int year) {
        System.out.println("     " + getMonthName(month) + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        int firstDay = getFirstDayOfMonth(month, year);
        int numberOfDays = getNumberOfDays(month, year);

        
        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }

        for (int day = 1; day <= numberOfDays; day++) {
            System.out.printf("%3d ", day);
            if ((day + firstDay) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        System.out.print("Enter year: ");
        int year = sc.nextInt();

        if (month < 1 || month > 12) {
            System.out.println("Invalid month entered.");
        } else {
            displayCalendar(month, year);
        }
        sc.close();
    }
}
