package RegexAndJUnit;

import java.util.regex.*;
import java.util.*;

public class LinkExtractor {
    public static List<String> extractLinks(String text) {
        List<String> links = new ArrayList<>();
        Matcher m = Pattern.compile("https?://\\S+").matcher(text);
        while (m.find()) links.add(m.group());
        return links;
    }
    public static void main(String[] args) {
        String s = "Visit https://www.google.com and http://example.org for more info.";
        System.out.println(extractLinks(s));
    }
}