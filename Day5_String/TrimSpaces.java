package Day5_String;

import java.util.Scanner;

public class TrimSpaces {

    
    public static int[] trimIndices(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start <= end && str.charAt(start) == ' ') {
            start++;
        }
        while (end >= start && str.charAt(end) == ' ') {
            end--;
        }
        return new int[]{start, end};
    }

    
    public static String substringCustom(String str, int start, int end) {
        if (start < 0 || end >= str.length() || start > end) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
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
        System.out.print("Enter a string with leading and trailing spaces: ");
        String input = scanner.nextLine();

        int[] indices = trimIndices(input);
        String trimmedCustom = substringCustom(input, indices[0], indices[1]);
        String trimmedBuiltIn = input.trim();

        System.out.println("Custom trimmed string: '" + trimmedCustom + "'");
        System.out.println("Built-in trimmed string: '" + trimmedBuiltIn + "'");

        boolean isEqual = compareStrings(trimmedCustom, trimmedBuiltIn);
        System.out.println("Are both trimmed strings equal? " + isEqual);

        scanner.close();
    }
}
