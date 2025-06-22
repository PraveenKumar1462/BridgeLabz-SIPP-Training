import java.util.Scanner;

public class FibonacciSequenceGenerator {

    private static void printFibonacciSequence(int terms) {
        int a = 0, b = 1;
        System.out.println("Fibonacci sequence up to " + terms + " terms:");
        for (int i = 1; i <= terms; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms for Fibonacci sequence: ");
        int terms = scanner.nextInt();
        if (terms <= 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            printFibonacciSequence(terms);
        }
        scanner.close();
    }
}
