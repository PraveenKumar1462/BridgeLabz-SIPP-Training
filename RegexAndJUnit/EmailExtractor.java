package RegexAndJUnit;

import java.util.regex.*;
import java.util.*;

public class EmailExtractor {
    public static List<String> extractEmails(String text) {
        List<String> emails = new ArrayList<>();
        Matcher m = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}").matcher(text);
        while (m.find()) emails.add(m.group());
        return emails;
    }
    public static void main(String[] args) {
        String s = "Contact us at support@example.com and info@company.org";
        System.out.println(extractEmails(s));
    }
}