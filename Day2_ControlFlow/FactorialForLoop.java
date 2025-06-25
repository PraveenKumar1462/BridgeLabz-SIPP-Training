package Day2_ControlFlow;

import java.util.Scanner;

public class FactorialForLoop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = input.nextInt();

        if (n < 0) {
            System.out.println("Invalid input. Please enter a positive integer.");
        } else {
            int factorial = 1;
            for (int i = 1; i <= n; i++) {
                factorial *= i;
            }
            System.out.println("The factorial of " + n + " is " + factorial);
        }
        input.close();
    }
}
