package Day4and5_LinearAndBinarySearch;

public class ReverseStringWithStringBuilder {
    public static String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(reverse("hello"));
    }
}