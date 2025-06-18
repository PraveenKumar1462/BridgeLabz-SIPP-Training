package Day5_String;

import java.util.Scanner;

public class WordLengthAnalysis {

    
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

    
    public static int[] findShortestLongest(String[][] wordLenArr) {
        int shortestIndex = 0;
        int longestIndex = 0;
        int shortestLen = Integer.parseInt(wordLenArr[0][1]);
        int longestLen = shortestLen;

        for (int i = 1; i < wordLenArr.length; i++) {
            int len = Integer.parseInt(wordLenArr[i][1]);
            if (len < shortestLen) {
                shortestLen = len;
                shortestIndex = i;
            }
            if (len > longestLen) {
                longestLen = len;
                longestIndex = i;
            }
        }
        return new int[]{shortestIndex, longestIndex};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String input = scanner.nextLine();

        String[] words = splitWords(input);
        String[][] wordLenArr = wordLengths(words);
        int[] indices = findShortestLongest(wordLenArr);

        System.out.println("Words and their lengths:");
        System.out.printf("%-15s %-10s%n", "Word", "Length");
        for (String[] row : wordLenArr) {
            System.out.printf("%-15s %-10s%n", row[0], row[1]);
        }

        System.out.println("Shortest word: " + wordLenArr[indices[0]][0] + " (Length: " + wordLenArr[indices[0]][1] + ")");
        System.out.println("Longest word: " + wordLenArr[indices[1]][0] + " (Length: " + wordLenArr[indices[1]][1] + ")");

        scanner.close();
    }
}
