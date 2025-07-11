package Day4and5_LinearAndBinarySearch;

import java.io.*;

public class InputStreamReaderUserToFile {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        String line;
        System.out.println("Enter lines (type 'exit' to finish):");
        while (!(line = br.readLine()).equals("exit")) {
            bw.write(line);
            bw.newLine();
        }
        bw.close();
        br.close();
    }
}