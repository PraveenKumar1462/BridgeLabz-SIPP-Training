package RegexAndJUnit;

import java.util.regex.*;
import java.util.*;

public class CurrencyExtractor {
    public static List<String> extractCurrency(String text) {
        List<String> result = new ArrayList<>();
        Matcher m = Pattern.compile("\\$?\\d+\\.\\d{2}").matcher(text);
        while (m.find()) result.add(m.group());
        return result;
    }
    public static void main(String[] args) {
        String s = "The price is $45.99, and the discount is 10.50.";
        System.out.println(extractCurrency(s));
    }
}