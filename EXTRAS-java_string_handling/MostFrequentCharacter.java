import java.util.HashMap;
import java.util.Map;

public class MostFrequentCharacter {
    public static void main(String[] args) {
        String input = "success";
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char ch : input.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        char mostFrequent = input.charAt(0);
        int maxCount = 0;

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostFrequent = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        System.out.println("Most Frequent Character: '" + mostFrequent + "'");
    }
}
