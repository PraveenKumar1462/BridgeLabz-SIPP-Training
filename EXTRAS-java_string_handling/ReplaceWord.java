import java.util.Scanner;

public class ReplaceWord {

    public static String replaceWord(String sentence, String oldWord, String newWord) {
        
        return sentence.replaceAll("\\b" + oldWord + "\\b", newWord);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        System.out.print("Enter the word to be replaced: ");
        String oldWord = scanner.next();

        System.out.print("Enter the new word: ");
        String newWord = scanner.next();

        String replacedSentence = replaceWord(sentence, oldWord, newWord);
        System.out.println("Modified sentence: " + replacedSentence);

        scanner.close();
    }
}
