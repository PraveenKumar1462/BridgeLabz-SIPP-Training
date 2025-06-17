package Day2_ControlFlow;

import java.util.Scanner;

public class CountdownRocketLaunch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter countdown start number: ");
        int counter = input.nextInt();

        while (counter >= 1) {
            System.out.println(counter);
            counter--;
        }
        input.close();
    }
}
