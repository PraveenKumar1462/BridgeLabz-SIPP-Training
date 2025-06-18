package Day5_String;

public class NullPointerExceptionDemo {

    
    public static void generateException() {
        String text = null;
        
        System.out.println(text.length());
    }

    
    public static void handleException() {
        String text = null;
        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("Calling method to generate exception:");
        try {
            generateException();
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }

        System.out.println("Calling method to handle exception:");
        handleException();
    }
}
