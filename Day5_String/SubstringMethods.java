package Day5_String;

import java.util.Scanner;

public class SubstringMethods {

    
    public static String substringCustom(String str, int start, int end) {
        if (start < 0 || end > str.length() || start > end) {
            throw new StringIndexOutOfBoundsException("Invalid start or end index");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            sb.append(str.charAt(i));
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

        System.out.print("Enter start index: ");
        int start = scanner.nextInt();

        System.out.print("Enter end index: ");
        int end = scanner.nextInt();

        try {
            String customSub = substringCustom(input, start, end);
            String builtInSub = input.substring(start, end);

            System.out.println("Custom substring: " + customSub);
            System.out.println("Built-in substring: " + builtInSub);

            boolean isEqual = compareStrings(customSub, builtInSub);
            System.out.println("Are both substrings equal? " + isEqual);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        scanner.close();
    }
}
