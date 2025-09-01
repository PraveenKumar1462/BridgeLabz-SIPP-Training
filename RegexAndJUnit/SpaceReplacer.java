package RegexAndJUnit;

public class SpaceReplacer {
    public static String replaceMultipleSpaces(String text) {
        return text.replaceAll("\\s+", " ").trim();
    }
    public static void main(String[] args) {
        String s = "This   is   an   example   with   multiple   spaces.";
        System.out.println(replaceMultipleSpaces(s));
    }
}