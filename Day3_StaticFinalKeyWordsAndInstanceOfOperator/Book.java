package Day3_StaticFinalKeyWordsAndInstanceOfOperator;

public class Book {
    private static String libraryName = "BridgeLabz Library";
    private final String isbn;
    private String title;
    private String author;


    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }


    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }


    public void displayBookDetails() {
        if (this instanceof Book) {
            System.out.println("ISBN: " + isbn + ", Title: " + title + ", Author: " + author + ", Library: " + libraryName);
        } else {
            System.out.println("Not a valid Book object.");
        }
    }

    public static void main(String[] args) {
        Book.displayLibraryName();

        Book book1 = new Book("Effective Java", "Joshua Bloch", "978-0134685991");
        Book book2 = new Book("Clean Code", "Robert C. Martin", "978-0132350884");

        book1.displayBookDetails();
    }
}