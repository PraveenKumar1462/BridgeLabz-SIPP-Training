package Day1_DataStructureLinkedList;

public class LibraryManagementSystem {
    private static class Node {
        String bookTitle;
        String author;
        String genre;
        int bookId;
        boolean isAvailable;
        Node next;
        Node prev;

        Node(String bookTitle, String author, String genre, int bookId, boolean isAvailable) {
            this.bookTitle = bookTitle;
            this.author = author;
            this.genre = genre;
            this.bookId = bookId;
            this.isAvailable = isAvailable;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;

    public LibraryManagementSystem() {
        head = null;
        tail = null;
    }

    public void addAtBeginning(String bookTitle, String author, String genre, int bookId, boolean isAvailable) {
        Node newNode = new Node(bookTitle, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addAtEnd(String bookTitle, String author, String genre, int bookId, boolean isAvailable) {
        Node newNode = new Node(bookTitle, author, genre, bookId, isAvailable);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void addAtPosition(String bookTitle, String author, String genre, int bookId, boolean isAvailable, int position) {
        if (position <= 0) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            addAtBeginning(bookTitle, author, genre, bookId, isAvailable);
            return;
        }
        Node newNode = new Node(bookTitle, author, genre, bookId, isAvailable);
        Node current = head;
        for (int i = 1; i < position - 1; i++) {
            if (current == null) {
                System.out.println("Position out of bounds.");
                return;
            }
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of bounds.");
            return;
        }
        newNode.next = current.next;
        newNode.prev = current;
        if (current.next != null) {
            current.next.prev = newNode;
        } else {
            tail = newNode;
        }
        current.next = newNode;
    }


    public void removeByBookId(int bookId) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        Node current = head;
        while (current != null && current.bookId != bookId) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Book with ID " + bookId + " not found.");
            return;
        }
        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }
        System.out.println("Removed book with ID: " + bookId);
    }


    public void searchByBookTitle(String bookTitle) {
        Node current = head;
        boolean found = false;
        while (current != null) {
            if (current.bookTitle.equalsIgnoreCase(bookTitle)) {
                System.out.println("Book ID: " + current.bookId + ", Author: " + current.author + ", Genre: " + current.genre + ", Available: " + current.isAvailable);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No books found with title: " + bookTitle);
        }
    }


    public void searchByAuthor(String author) {
        Node current = head;
        boolean found = false;
        while (current != null) {
            if (current.author.equalsIgnoreCase(author)) {
                System.out.println("Book ID: " + current.bookId + ", Title: " + current.bookTitle + ", Genre: " + current.genre + ", Available: " + current.isAvailable);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No books found by author: " + author);
        }
    }


    public void updateAvailability(int bookId, boolean isAvailable) {
        Node current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                current.isAvailable = isAvailable;
                System.out.println("Updated availability for book ID " + bookId + " to " + isAvailable);
                return;
            }
            current = current.next;
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }


    public void displayForward() {
        if (head == null) {
            System.out.println("No books to display.");
            return;
        }
        Node current = head;
        System.out.println("Books (Forward):");
        while (current != null) {
            System.out.println("Book ID: " + current.bookId + ", Title: " + current.bookTitle + ", Author: " + current.author + ", Genre: " + current.genre + ", Available: " + current.isAvailable);
            current = current.next;
        }
    }


    public void displayReverse() {
        if (tail == null) {
            System.out.println("No books to display.");
            return;
        }
        Node current = tail;
        System.out.println("Books (Reverse):");
        while (current != null) {
            System.out.println("Book ID: " + current.bookId + ", Title: " + current.bookTitle + ", Author: " + current.author + ", Genre: " + current.genre + ", Available: " + current.isAvailable);
            current = current.prev;
        }
    }


    public int countBooks() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }


    public static void main(String[] args) {
        LibraryManagementSystem lms = new LibraryManagementSystem();
        lms.addAtEnd("The Hobbit", "J.R.R. Tolkien", "Fantasy", 101, true);
        lms.addAtBeginning("1984", "George Orwell", "Dystopian", 102, false);
        lms.addAtPosition("To Kill a Mockingbird", "Harper Lee", "Classic", 103, true, 2);
        lms.displayForward();
        lms.displayReverse();
        lms.searchByBookTitle("1984");
        lms.searchByAuthor("Harper Lee");
        lms.updateAvailability(102, true);
        lms.displayForward();
        System.out.println("Total books in library: " + lms.countBooks());
        lms.removeByBookId(101);
        lms.displayForward();
    }
}
