package Day2_ControlFlow;

import java.util.Scanner;

public class CheckVowelConsonantDigitSpecialCharacter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a character: ");
        char ch = input.next().toLowerCase().charAt(0);

        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                System.out.println(ch + " is a vowel");
            } else {
                System.out.println(ch + " is a consonant");
            }
        } else if (ch >= '0' && ch <= '9') {
            System.out.println(ch + " is a digit");
        } else {
            System.out.println(ch + " is a special character");
        }
        input.close();
    }
}
