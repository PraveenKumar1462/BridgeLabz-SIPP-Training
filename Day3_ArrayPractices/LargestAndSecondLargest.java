package Day3_ArrayPractices;

import java.util.Scanner;

public class LargestAndSecondLargest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        int temp = number;
        while (temp != 0) {
            if (index == maxDigit) {
        
                maxDigit *= 2;
                int[] tempDigits = new int[maxDigit];
                System.arraycopy(digits, 0, tempDigits, 0, digits.length);
                digits = tempDigits;
            }
            digits[index++] = temp % 10;
            temp /= 10;
        }

        if (index == 0) {
            System.out.println("No digits found.");
            input.close();
            return;
        }

        int largest = digits[0];
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 1; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        System.out.println("Largest digit: " + largest);
        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("No second largest digit found.");
        } else {
            System.out.println("Second largest digit: " + secondLargest);
        }
        input.close();
    }
}
