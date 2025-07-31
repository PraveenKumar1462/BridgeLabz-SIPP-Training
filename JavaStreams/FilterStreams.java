import java.io.*;

public class FilterStreams {
    public static void main(String[] args) {
        String sourceFile = "input.txt";
        String destFile = "output.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(destFile))) {

            int ch;
            while ((ch = br.read()) != -1) {
                char c = (char) ch;
                if (Character.isUpperCase(c)) {
                    c = Character.toLowerCase(c);
                }
                bw.write(c);
            }
            System.out.println("File copied with uppercase converted to lowercase.");

        } catch (IOException e) {
            System.out.println("Error processing files: " + e.getMessage());
        }
    }
}
