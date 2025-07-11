package Day4and5_LinearAndBinarySearch;

import java.io.*;

public class CountWordInFile {
    public static void main(String[] args) throws IOException {
        String target = "java";
        int count = 0;
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (word.equals(target)) count++;
            }
        }
        br.close();
        System.out.println("Occurrences of '" + target + "': " + count);
    }
}