package Day5_String;

import java.util.Arrays;
import java.util.Scanner;

public class WordSplitCompare {

    
    public static int stringLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            
        }
        return count;
    }

    
    public static String[] splitWords(String text) {
        int len = stringLength(text);
        int wordCount = 0;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }
        wordCount++;

        String[] words = new String[wordCount];
        int wordIndex = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            char c = text.charAt(i);
            if (c != ' ') {
                sb.append(c);
            } else {
                words[wordIndex++] = sb.toString();
                sb = new StringBuilder();
            }
        }
        words[wordIndex] = sb.toString();

        return words;
    }

    
    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String input = scanner.nextLine();

        String[] customSplit = splitWords(input);
        String[] builtInSplit = input.split(" ");

        boolean isEqual = compareStringArrays(customSplit, builtInSplit);

        System.out.println("Custom split words: " + Arrays.toString(customSplit));
        System.out.println("Built-in split words: " + Arrays.toString(builtInSplit));
        System.out.println("Are both splits equal? " + isEqual);

        scanner.close();
    }
}
