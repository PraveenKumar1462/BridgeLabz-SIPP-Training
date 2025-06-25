package Day2_ControlFlow;

import java.util.Scanner;

public class CheckVowel {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a character: ");
        char ch = input.next().toLowerCase().charAt(0);

        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            System.out.println(ch + " is a vowel");
        } else {
            System.out.println(ch + " is not a vowel");
        }
        input.close();
    }
}
