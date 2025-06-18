package Day5_String;

import java.util.Scanner;

public class WordLengthTable {

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

    
    public static String[][] wordLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(stringLength(words[i]));
        }
        return result;
    }

    
    public static void displayWordLengths(String[][] arr) {
        System.out.printf("%-15s %-10s%n", "Word", "Length");
        for (String[] row : arr) {
            System.out.printf("%-15s %-10d%n", row[0], Integer.parseInt(row[1]));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String input = scanner.nextLine();

        String[] words = splitWords(input);
        String[][] wordLenArr = wordLengths(words);
        displayWordLengths(wordLenArr);

        scanner.close();
    }
}
