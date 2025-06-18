package Day5_String;

import java.util.Scanner;

public class CharArrayMethods {

    
    public static char[] toCharArrayCustom(String str) {
        char[] chars = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }
        return chars;
    }

    
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.next();

        char[] customChars = toCharArrayCustom(input);
        char[] builtInChars = input.toCharArray();

        boolean isEqual = compareCharArrays(customChars, builtInChars);

        System.out.println("Custom char array: ");
        for (char c : customChars) {
            System.out.print(c + " ");
        }
        System.out.println();

        System.out.println("Built-in toCharArray: ");
        for (char c : builtInChars) {
            System.out.print(c + " ");
        }
        System.out.println();

        System.out.println("Are both arrays equal? " + isEqual);

        scanner.close();
    }
}
