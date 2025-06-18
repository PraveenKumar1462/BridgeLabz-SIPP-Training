package Day5_String;

import java.util.Random;
import java.util.Scanner;

public class VotingEligibility {

    
    public static int[] generateAges(int n) {
        Random rand = new Random();
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            ages[i] = rand.nextInt(100);
        }
        return ages;
    }

    
    public static String[][] checkEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            if (ages[i] < 0) {
                result[i][1] = "false";
            } else if (ages[i] >= 18) {
                result[i][1] = "true";
            } else {
                result[i][1] = "false";
            }
        }
        return result;
    }

    
    public static void displayEligibility(String[][] arr) {
        System.out.printf("%-10s %-10s%n", "Age", "Can Vote");
        for (String[] row : arr) {
            System.out.printf("%-10s %-10s%n", row[0], row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();

        int[] ages = generateAges(n);
        String[][] eligibility = checkEligibility(ages);
        displayEligibility(eligibility);

        scanner.close();
    }
}
