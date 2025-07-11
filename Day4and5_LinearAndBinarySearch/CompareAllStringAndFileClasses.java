package Day4and5_LinearAndBinarySearch;

import java.io.*;

public class CompareAllStringAndFileClasses {
    public static void main(String[] args) throws IOException {

        int n = 1_000_000;
        long start, end;

        StringBuilder sb = new StringBuilder();
        start = System.nanoTime();
        for (int i = 0; i < n; i++) sb.append("hello");
        end = System.nanoTime();
        System.out.println("StringBuilder: " + (end - start) / 1_000_000 + " ms");

        StringBuffer sbuf = new StringBuffer();
        start = System.nanoTime();
        for (int i = 0; i < n; i++) sbuf.append("hello");
        end = System.nanoTime();
        System.out.println("StringBuffer: " + (end - start) / 1_000_000 + " ms");


        start = System.nanoTime();
        BufferedReader br = new BufferedReader(new FileReader("largefile.txt"));
        int wordCount = 0;
        String line;
        while ((line = br.readLine()) != null) {
            wordCount += line.split("\\s+").length;
        }
        br.close();
        end = System.nanoTime();
        System.out.println("FileReader word count: " + wordCount + ", time: " + (end - start) / 1_000_000 + " ms");

        start = System.nanoTime();
        BufferedReader br2 = new BufferedReader(
            new InputStreamReader(new FileInputStream("largefile.txt"), "UTF-8"));
        wordCount = 0;
        while ((line = br2.readLine()) != null) {
            wordCount += line.split("\\s+").length;
        }
        br2.close();
        end = System.nanoTime();
        System.out.println("InputStreamReader word count: " + wordCount + ", time: " + (end - start) / 1_000_000 + " ms");
    }
}