import java.io.*;

public class FileHandling {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destFile = "destination.txt";

        try (FileInputStream fis = new FileInputStream(sourceFile);
            FileOutputStream fos = new FileOutputStream(destFile)) {

            int byteRead;
            while ((byteRead = fis.read()) != -1) {
                fos.write(byteRead);
            }
            System.out.println("File copied successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("Source file does not exist.");
        } catch (IOException e) {
            System.out.println("An error occurred during file handling: " + e.getMessage());
        }
    }
}
