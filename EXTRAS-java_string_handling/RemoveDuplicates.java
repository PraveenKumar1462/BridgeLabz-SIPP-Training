import java.util.LinkedHashSet;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String input = "programming";
        StringBuilder output = new StringBuilder();
        LinkedHashSet<Character> set = new LinkedHashSet<>();

        for (char ch : input.toCharArray()) {
            if (!set.contains(ch)) {
                set.add(ch);
                output.append(ch);
            }
        }
        System.out.println("String after removing duplicates: " + output.toString());
    }
}
