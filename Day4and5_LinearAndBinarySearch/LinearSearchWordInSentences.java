package Day4and5_LinearAndBinarySearch;

public class LinearSearchWordInSentences {
    public static String findSentence(String[] sentences, String word) {
        for (String s : sentences)
            if (s.contains(word)) return s;
        return "Not Found";
    }
    public static void main(String[] args) {
        String[] sentences = {"Java is fun", "I love coding", "Hello world"};
        System.out.println(findSentence(sentences, "coding"));
    }
}