package RegexAndJUnit;

import java.util.regex.*;
import java.util.*;

public class CapitalizedWordsExtractor {
    public static List<String> extract(String text) {
        List<String> result = new ArrayList<>();
        Matcher m = Pattern.compile("\\b[A-Z][a-zA-Z]*\\b").matcher(text);
        while (m.find()) result.add(m.group());
        return result;
    }
    public static void main(String[] args) {
        String s = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        System.out.println(extract(s));
    }
}