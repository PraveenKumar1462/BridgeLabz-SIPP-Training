package Day4_ObjectOrientedDesignPrinciples;

import java.util.*;


public class LibraryBooks {

    static class Library {
        private String name;
        private List<Book> books;

        public Library(String name) {
            this.name = name;
            this.books = new ArrayList<>();
        }

        public void addBook(Book book) {
            books.add(book);
        }

        public void removeBook(Book book) {
            books.remove(book);
        }

        public List<Book> getBooks() {
            return books;
        }

        public String getName() {
            return name;
        }
    }

    static class Book {
        private String title;
        private String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }
    }

    public static void main(String[] args) {
        System.out.println("Problem 1: Library and Books (Aggregation)");
        Book b1 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        Book b2 = new Book("1984", "George Orwell");
        Book b3 = new Book("To Kill a Mockingbird", "Harper Lee");

        Library lib1 = new Library("Central Library");
        Library lib2 = new Library("Community Library");

        lib1.addBook(b1);
        lib1.addBook(b2);

        lib2.addBook(b2);
        lib2.addBook(b3);

        System.out.println(lib1.getName() + " has books:");
        for (Book b : lib1.getBooks()) {
            System.out.println("- " + b.getTitle() + " by " + b.getAuthor());
        }

        System.out.println(lib2.getName() + " has books:");
        for (Book b : lib2.getBooks()) {
            System.out.println("- " + b.getTitle() + " by " + b.getAuthor());
        }
    }
}
