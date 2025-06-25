package Day5_String;

import java.util.Scanner;

public class UppercaseConversion {

    public static String toUppercaseCustom(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {
                c = (char) (c - 32);
            }
            sb.append(c);
        }
        return sb.toString();
    }


    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String customUpper = toUppercaseCustom(input);
        String builtInUpper = input.toUpperCase();

        System.out.println("Custom uppercase: " + customUpper);
        System.out.println("Built-in uppercase: " + builtInUpper);

        boolean isEqual = compareStrings(customUpper, builtInUpper);
        System.out.println("Are both uppercase strings equal? " + isEqual);

        scanner.close();
    }
}
