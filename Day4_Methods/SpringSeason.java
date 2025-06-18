package Day4_Methods;

import java.util.Scanner;

public class SpringSeason {
    public static boolean isSpringSeason(int month, int day) {
        if (month < 3 || month > 6) {
            return false;
        }
        if (month == 3 && day < 20) {
            return false;
        }
        if (month == 6 && day > 20) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        System.out.print("Enter day (1-31): ");
        int day = sc.nextInt();

        if (isSpringSeason(month, day)) {
            System.out.println("It's a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
        sc.close();
    }
}