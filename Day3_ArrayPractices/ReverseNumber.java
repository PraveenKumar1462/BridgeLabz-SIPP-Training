package Day3_ArrayPractices;

import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int countDigits = 0;
        int temp = Math.abs(number);
        if (temp == 0) {
            countDigits = 1;
        } else {
            while (temp != 0) {
                temp /= 10;
                countDigits++;
            }
        }

        int[] digits = new int[countDigits];
        temp = Math.abs(number);
        for (int i = 0; i < countDigits; i++) {
            digits[i] = temp % 10;
            temp /= 10;
        }

        System.out.println("Digits in reverse order:");
        for (int i = 0; i < countDigits; i++) {
            System.out.print(digits[i] + " ");
        }
        System.out.println();
        input.close();
    }
}
