public class FindSubstringOccurrences {
    public static void main(String[] args) {
        String str = "This is a test string. This test is simple.";
        String substr = "is";
        int count = 0;
        int index = 0;

        while ((index = str.indexOf(substr, index)) != -1) {
            count++;
            index += substr.length();
        }

        System.out.println("Substring '" + substr + "' occurs " + count + " times.");
    }
}
