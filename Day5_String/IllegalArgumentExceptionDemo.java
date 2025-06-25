package Day5_String;

import java.util.Scanner;

public class IllegalArgumentExceptionDemo {

    
    public static void generateException(String str) {
        
        System.out.println(str.substring(5, 2));
    }

    
    public static void handleException(String str) {
        try {
            System.out.println(str.substring(5, 2));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("Calling method to generate exception:");
        try {
            generateException(input);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }

        System.out.println("Calling method to handle exception:");
        handleException(input);

        scanner.close();
    }
}
