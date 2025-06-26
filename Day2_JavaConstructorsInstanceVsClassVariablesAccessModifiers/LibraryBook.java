public class LibraryBook {
    private String title;
    private String author;
    private double price;
    private boolean available;

    public LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = true;
    }

    public boolean borrow() {
        if (available) {
            available = false;
            System.out.println(title + " has been borrowed.");
            return true;
        } else {
            System.out.println(title + " is not available.");
            return false;
        }
    }

    public void display() {
        System.out.println("Title: " + title + ", Author: " + author + ", Price: " + price + ", Available: " + available);
    }

    public static void main(String[] args) {
        LibraryBook book = new LibraryBook("Effective Java", "Joshua Bloch", 45.0);
        book.display();
        book.borrow();
        book.display();
        book.borrow();
    }
}