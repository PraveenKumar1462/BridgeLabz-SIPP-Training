package Day4and5_LinearAndBinarySearch;

public class ConcatenateStringsWithStringBuffer {
    public static String concatenate(String[] arr) {
        StringBuffer sb = new StringBuffer();
        for (String s : arr) sb.append(s);
        return sb.toString();
    }
    public static void main(String[] args) {
        String[] arr = {"Java", "is", "fun"};
        System.out.println(concatenate(arr));
    }
}