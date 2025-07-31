

import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static Map<String, Integer> countWordFrequency(String filePath) throws IOException {
        Map<String, Integer> wordFreq = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) {
            line = line.toLowerCase().replaceAll("[^a-z0-9\\s]", "");
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (!word.isEmpty()) {
                    wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
                }
            }
        }

        reader.close();
        return wordFreq;
    }

    public static void main(String[] args) throws IOException {
        String filePath = "input.txt";
        Map<String, Integer> result = countWordFrequency(filePath);
        System.out.println(result);
    }
}
