package Day2_ControlFlow;

import java.util.Scanner;

public class SumUntilZeroOrNegative {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sum = 0;

        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            int number = input.nextInt();
            if (number <= 0) {
                break;
            }
            sum += number;
        }
        System.out.println("The sum is " + sum);
        input.close();
    }
}
