package Day2_ControlFlow;

import java.util.Scanner;

public class NaturalNumberSumWhileLoop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = input.nextInt();

        if (n > 0) {
            int sumWhileLoop = 0;
            int i = 1;
            while (i <= n) {
                sumWhileLoop += i;
                i++;
            }
            int sumFormula = n * (n + 1) / 2;
            System.out.println("Sum using while loop: " + sumWhileLoop);
            System.out.println("Sum using formula: " + sumFormula);
            System.out.println("Both results are " + (sumWhileLoop == sumFormula ? "correct" : "incorrect"));
        } else {
            System.out.println("The number " + n + " is not a natural number");
        }
        input.close();
    }
}
