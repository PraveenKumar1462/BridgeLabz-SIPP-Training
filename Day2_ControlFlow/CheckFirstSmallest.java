package Day2_ControlFlow;

import java.util.Scanner;

public class CheckFirstSmallest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int number1 = input.nextInt();
        System.out.print("Enter second number: ");
        int number2 = input.nextInt();
        System.out.print("Enter third number: ");
        int number3 = input.nextInt();

        System.out.println("Is the first number the smallest? " + (number1 < number2 && number1 < number3));
        input.close();
    }
}
