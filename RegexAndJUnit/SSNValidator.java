package RegexAndJUnit;

public class SSNValidator {
    public static boolean isValid(String ssn) {
        return ssn.matches("^\\d{3}-\\d{2}-\\d{4}$");
    }
    public static void main(String[] args) {
        System.out.println(isValid("123-45-6789"));
        System.out.println(isValid("123456789"));
    }
}