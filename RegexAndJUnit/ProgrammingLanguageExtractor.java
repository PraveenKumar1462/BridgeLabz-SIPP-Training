package RegexAndJUnit;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;

public class ProgrammingLanguageExtractor {
    private static final String[] LANGUAGES = {
        "Java", "Python", "JavaScript", "Go", "C++", "C#", "Ruby", "PHP", "Swift", "Kotlin",
        "TypeScript", "Rust", "Scala", "R", "Perl", "Haskell", "C", "Objective-C", "Dart"
    };
    public static String[] extractLanguages(String text) {
        if (text == null || text.trim().isEmpty()) return new String[0];
        ArrayList<String> found = new ArrayList<>();
        for (String lang : LANGUAGES) {
            String regex = "\\b" + Pattern.quote(lang) + "\\b";
            Matcher m = Pattern.compile(regex, Pattern.CASE_INSENSITIVE).matcher(text);
            if (m.find()) found.add(lang);
        }
        return found.toArray(new String[0]);
    }
    public static void main(String[] args) {
        String s = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        System.out.println(String.join(", ", extractLanguages(s)));
    }
}