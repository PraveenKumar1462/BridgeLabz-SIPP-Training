import java.io.*;
import java.util.*;

public class CountWords {
    public static void main(String[] args) {
        String filename = "input.txt";
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (word.isEmpty()) continue;
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }


        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCount.entrySet());
        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("Top 5 most frequent words:");
        for (int i = 0; i < Math.min(5, sortedList.size()); i++) {
            Map.Entry<String, Integer> entry = sortedList.get(i);
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
