package Day6_AlgorithmsRuntimeAnalysisBigONotation;

import java.io.*;

public class FileReadPerformance {
    public static void main(String[] args) throws Exception {
        String filename = "largefile.txt";

        long start = System.nanoTime();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        while (br.readLine() != null) {}
        br.close();
        long end = System.nanoTime();
        System.out.println("FileReader: " + (end - start) / 1_000_000.0 + " ms");

        start = System.nanoTime();
        BufferedReader br2 = new BufferedReader(
            new InputStreamReader(new FileInputStream(filename), "UTF-8"));
        while (br2.readLine() != null) {}
        br2.close();
        end = System.nanoTime();
        System.out.println("InputStreamReader: " + (end - start) / 1_000_000.0 + " ms");
    }
}