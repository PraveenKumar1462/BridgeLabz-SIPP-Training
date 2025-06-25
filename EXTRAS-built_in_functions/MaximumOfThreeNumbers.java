import java.util.Scanner;

public class MaximumOfThreeNumbers {

    private static int findMaximum(int a, int b, int c) {
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        return max;
    }

    private static int[] takeInput(Scanner scanner) {
        int[] numbers = new int[3];
        System.out.println("Enter three integers:");
        for (int i = 0; i < 3; i++) {
            numbers[i] = scanner.nextInt();
        }
        return numbers;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = takeInput(scanner);
        int max = findMaximum(numbers[0], numbers[1], numbers[2]);
        System.out.println("Maximum of the three numbers is: " + max);
        scanner.close();
    }
}
