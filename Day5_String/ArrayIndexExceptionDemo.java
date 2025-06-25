package Day5_String;

import java.util.Scanner;

public class ArrayIndexExceptionDemo {

    
    public static void generateException(String[] arr) {
        
        System.out.println(arr[arr.length]);
    }

    
    public static void handleException(String[] arr) {
        try {
            System.out.println(arr[arr.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of names: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String[] names = new String[n];
        System.out.println("Enter names:");
        for (int i = 0; i < n; i++) {
            names[i] = scanner.nextLine();
        }

        System.out.println("Calling method to generate exception:");
        try {
            generateException(names);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }

        System.out.println("Calling method to handle exception:");
        handleException(names);

        scanner.close();
    }
}
