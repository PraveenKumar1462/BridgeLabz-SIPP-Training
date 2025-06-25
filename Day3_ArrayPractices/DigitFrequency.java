package Day3_ArrayPractices;

import java.util.Scanner;

public class DigitFrequency {
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
        for (int i = countDigits - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }

        int[] frequency = new int[10];
        for (int digit : digits) {
            frequency[digit]++;
        }

        System.out.println("Digit frequencies:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println(i + ": " + frequency[i]);
            }
        }
        input.close();
    }
}
