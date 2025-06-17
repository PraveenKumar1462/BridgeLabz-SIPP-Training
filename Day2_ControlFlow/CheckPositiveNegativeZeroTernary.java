package Day2_ControlFlow;

import java.util.Scanner;

public class CheckPositiveNegativeZeroTernary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        String result = (number > 0) ? "positive" : (number < 0) ? "negative" : "zero";
        System.out.println(result);
        input.close();
    }
}
