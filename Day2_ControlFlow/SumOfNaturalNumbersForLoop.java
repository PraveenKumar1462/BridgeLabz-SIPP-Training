package Day2_ControlFlow;

import java.util.Scanner;

public class SumOfNaturalNumbersForLoop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = input.nextInt();

        if (n > 0) {
            int sumForLoop = 0;
            for (int i = 1; i <= n; i++) {
                sumForLoop += i;
            }
            int sumFormula = n * (n + 1) / 2;
            System.out.println("Sum using for loop: " + sumForLoop);
            System.out.println("Sum using formula: " + sumFormula);
            System.out.println("Both results are " + (sumForLoop == sumFormula ? "correct" : "incorrect"));
        } else {
            System.out.println("The number " + n + " is not a natural number");
        }
        input.close();
    }
}
