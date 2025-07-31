package Workshop;

import java.util.Scanner;

public class paragraph {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a paragraph:");
        String paragraph = scanner.nextLine();

        System.out.println("Enter a word to search in the paragraph:");
        String searchWord = scanner.nextLine();

        String[] words = paragraph.split("\\s+");
        boolean found = false;
        for (String word : words) {
            if (word.equalsIgnoreCase(searchWord)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("The word '" + searchWord + "' was found in the paragraph.");
        } else {
            System.out.println("The word '" + searchWord + "' was NOT found in the paragraph.");
        }

        scanner.close();
    }
}
