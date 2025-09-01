package RegexAndJUnit;

public class CreditCardValidator {
    public static boolean isVisa(String card) {
        return card.matches("^4\\d{15}$");
    }
    public static boolean isMasterCard(String card) {
        return card.matches("^5\\d{15}$");
    }
    public static void main(String[] args) {
        System.out.println("Visa valid: " + isVisa("4123456789012345"));
        System.out.println("MasterCard valid: " + isMasterCard("5123456789012345"));
        System.out.println("Visa valid: " + isVisa("5123456789012345"));
        System.out.println("MasterCard valid: " + isMasterCard("4123456789012345"));
    }
}