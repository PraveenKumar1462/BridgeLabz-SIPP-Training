public class CompareTwoStrings {
    public static void main(String[] args) {
        String str1 = "apple";
        String str2 = "banana";

        int len1 = str1.length();
        int len2 = str2.length();
        int lim = Math.min(len1, len2);

        for (int i = 0; i < lim; i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if (c1 != c2) {
                if (c1 < c2) {
                    System.out.println("\"" + str1 + "\" comes before \"" + str2 + "\" in lexicographical order");
                } else {
                    System.out.println("\"" + str2 + "\" comes before \"" + str1 + "\" in lexicographical order");
                }
                return;
            }
        }

        if (len1 == len2) {
            System.out.println("Both strings are equal");
        } else if (len1 < len2) {
            System.out.println("\"" + str1 + "\" comes before \"" + str2 + "\" in lexicographical order");
        } else {
            System.out.println("\"" + str2 + "\" comes before \"" + str1 + "\" in lexicographical order");
        }
    }
}
