package Day4_Methods;

import java.util.Scanner;

public class NumberChecker {
    public static int countDigits(int number) {
        return String.valueOf(Math.abs(number)).length();
    }

    public static int[] storeDigits(int number) {
        String numStr = String.valueOf(Math.abs(number));
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = numStr.charAt(i) - '0';
        }
        return digits;
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int digit : digits) {
            if (digit != 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isArmstrongNumber(int[] digits) {
        int sum = 0;
        int n = digits.length;
        for (int digit : digits) {
            sum += Math.pow(digit, n);
        }
        int number = 0;
        for (int digit : digits) {
            number = number * 10 + digit;
        }
        return sum == number;
    }

    public static int[] findLargestAndSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int digit : digits) {
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest && digit != largest) {
                secondLargest = digit;
            }
        }
        return new int[]{largest, secondLargest};
    }

    public static int[] findSmallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int digit : digits) {
            if (digit < smallest) {
                secondSmallest = smallest;
                smallest = digit;
            } else if (digit < secondSmallest && digit != smallest) {
                secondSmallest = digit;
            }
        }
        return new int[]{smallest, secondSmallest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int count = countDigits(number);
        int[] digits = storeDigits(number);
        boolean isDuck = isDuckNumber(digits);
        boolean isArmstrong = isArmstrongNumber(digits);
        int[] largest = findLargestAndSecondLargest(digits);
        int[] smallest = findSmallestAndSecondSmallest(digits);

        System.out.println("Count of digits: " + count);
        System.out.print("Digits: ");
        for (int digit : digits) {
            System.out.print(digit + " ");
        }
        System.out.println();
        System.out.println("Is Duck Number: " + isDuck);
        System.out.println("Is Armstrong Number: " + isArmstrong);
        System.out.println("Largest digit: " + largest[0]);
        System.out.println("Second largest digit: " + largest[1]);
        System.out.println("Smallest digit: " + smallest[0]);
        System.out.println("Second smallest digit: " + smallest[1]);
        sc.close();
    }
}
