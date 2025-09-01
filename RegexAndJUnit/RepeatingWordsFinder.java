package RegexAndJUnit;

import java.util.HashSet;
import java.util.Set;

public class RepeatingWordsFinder {
    public static String[] findRepeatingWords(String text) {
        if (text == null || text.trim().isEmpty()) return new String[0];
        String[] words = text.toLowerCase().split("\\s+");
        Set<String> seen = new HashSet<>();
        Set<String> repeating = new HashSet<>();
        for (String word : words) {
            word = word.replaceAll("[^a-zA-Z]", "");
            if (!word.isEmpty()) {
                if (seen.contains(word)) repeating.add(word);
                else seen.add(word);
            }
        }
        return repeating.toArray(new String[0]);
    }
    public static void main(String[] args) {
        String s = "This is is a repeated repeated word test.";
        System.out.println(String.join(", ", findRepeatingWords(s)));
    }
}