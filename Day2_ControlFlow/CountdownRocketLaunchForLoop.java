package Day2_ControlFlow;

import java.util.Scanner;

public class CountdownRocketLaunchForLoop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter countdown start number: ");
        int counter = input.nextInt();

        for (int i = counter; i >= 1; i--) {
            System.out.println(i);
        }
        input.close();
    }
}
