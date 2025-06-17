package Day2_ControlFlow;

import java.util.Scanner;

public class CheckUppercaseLowercase {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a character: ");
        char ch = input.next().charAt(0);

        if (ch >= 'A' && ch <= 'Z') {
            System.out.println(ch + " is uppercase");
        } else if (ch >= 'a' && ch <= 'z') {
            System.out.println(ch + " is lowercase");
        } else {
            System.out.println(ch + " is not an alphabet");
        }
        input.close();
    }
}
