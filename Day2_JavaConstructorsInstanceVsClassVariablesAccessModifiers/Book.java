public class Book {
    private String title;
    private String author;
    private double price;

    public Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
    }

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void display() {
        System.out.println("Title: " + title + ", Author: " + author + ", Price: " + price);
    }

    public static void main(String[] args) {
        Book defaultBook = new Book();
        Book paramBook = new Book("Java Basics", "John Doe", 199.99);
        defaultBook.display();
        paramBook.display();
    }
}