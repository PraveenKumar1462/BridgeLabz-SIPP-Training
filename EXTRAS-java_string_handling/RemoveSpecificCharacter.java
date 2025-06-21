public class RemoveSpecificCharacter {
    public static void main(String[] args) {
        String input = "Hello World";
        char charToRemove = 'l';
        StringBuilder output = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (ch != charToRemove) {
                output.append(ch);
            }
        }

        System.out.println("Modified String: " + output.toString());
    }
}
