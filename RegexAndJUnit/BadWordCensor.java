package RegexAndJUnit;

import java.util.*;

public class BadWordCensor {
    public static String censor(String text, List<String> badWords) {
        for (String word : badWords) {
            text = text.replaceAll("(?i)\\b" + word + "\\b", "****");
        }
        return text;
    }
    public static void main(String[] args) {
        String s = "This is a damn bad example with some stupid words.";
        List<String> badWords = Arrays.asList("damn", "stupid");
        System.out.println(censor(s, badWords));
    }
}