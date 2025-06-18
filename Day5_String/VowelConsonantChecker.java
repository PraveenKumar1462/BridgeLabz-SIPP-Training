package Day5_String;

import java.util.Scanner;

public class VowelConsonantChecker {

    
    public static String checkCharType(char c) {
        if (c >= 'A' && c <= 'Z') {
            c = (char) (c + 32);
        }
        if (c < 'a' || c > 'z') {
            return "Not a Letter";
        }
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return "Vowel";
        }
        return "Consonant";
    }

    
    public static String[][] findCharTypes(String str) {
        String[][] result = new String[str.length()][2];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            result[i][0] = String.valueOf(c);
            result[i][1] = checkCharType(c);
        }
        return result;
    }

    
    public static void displayCharTypes(String[][] arr) {
        System.out.printf("%-10s %-15s%n", "Character", "Type");
        for (String[] row : arr) {
            System.out.printf("%-10s %-15s%n", row[0], row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String[][] charTypes = findCharTypes(input);
        displayCharTypes(charTypes);

        scanner.close();
    }
}
