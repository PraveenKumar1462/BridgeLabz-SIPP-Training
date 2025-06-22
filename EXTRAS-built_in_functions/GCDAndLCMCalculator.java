import java.util.Scanner;

public class GCDAndLCMCalculator {

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        int gcdValue = gcd(num1, num2);
        int lcmValue = lcm(num1, num2);

        System.out.println("GCD of " + num1 + " and " + num2 + " is: " + gcdValue);
        System.out.println("LCM of " + num1 + " and " + num2 + " is: " + lcmValue);

        scanner.close();
    }
}
