package RegexAndJUnit;

import java.util.regex.*;
import java.util.*;

public class DateExtractor {
    public static List<String> extractDates(String text) {
        List<String> dates = new ArrayList<>();
        Matcher m = Pattern.compile("\\b\\d{2}/\\d{2}/\\d{4}\\b").matcher(text);
        while (m.find()) dates.add(m.group());
        return dates;
    }
    public static void main(String[] args) {
        String s = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";
        System.out.println(extractDates(s));
    }
}