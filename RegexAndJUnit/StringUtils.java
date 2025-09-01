package RegexAndJUnit;

public class StringUtils {
    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    public static boolean isPalindrome(String str) {
        String rev = reverse(str);
        return str.equals(rev);
    }
    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }
}