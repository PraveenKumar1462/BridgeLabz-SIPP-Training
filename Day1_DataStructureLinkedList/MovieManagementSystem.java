package Day1_DataStructureLinkedList;

public class MovieManagementSystem {
    private static class Node {
        String title;
        String director;
        int year;
        double rating;
        Node next;
        Node prev;

        Node(String title, String director, int year, double rating) {
            this.title = title;
            this.director = director;
            this.year = year;
            this.rating = rating;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;

    public MovieManagementSystem() {
        head = null;
        tail = null;
    }

    public void addAtBeginning(String title, String director, int year, double rating) {
        Node newNode = new Node(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }


    public void addAtEnd(String title, String director, int year, double rating) {
        Node newNode = new Node(title, director, year, rating);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }


    public void addAtPosition(String title, String director, int year, double rating, int position) {
        if (position <= 0) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }
        Node newNode = new Node(title, director, year, rating);
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


    public void removeByTitle(String title) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = head;
        while (current != null && !current.title.equals(title)) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Movie with title \"" + title + "\" not found.");
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
        System.out.println("Removed movie with title: " + title);
    }


    public void searchByDirector(String director) {
        Node current = head;
        boolean found = false;
        while (current != null) {
            if (current.director.equalsIgnoreCase(director)) {
                System.out.println("Title: " + current.title + ", Year: " + current.year + ", Rating: " + current.rating);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No movies found by director: " + director);
        }
    }


    public void searchByRating(double rating) {
        Node current = head;
        boolean found = false;
        while (current != null) {
            if (current.rating == rating) {
                System.out.println("Title: " + current.title + ", Director: " + current.director + ", Year: " + current.year);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No movies found with rating: " + rating);
        }
    }

    public void updateRating(String title, double newRating) {
        Node current = head;
        while (current != null) {
            if (current.title.equals(title)) {
                current.rating = newRating;
                System.out.println("Updated rating for \"" + title + "\" to " + newRating);
                return;
            }
            current = current.next;
        }
        System.out.println("Movie with title \"" + title + "\" not found.");
    }


    public void displayForward() {
        if (head == null) {
            System.out.println("No movies to display.");
            return;
        }
        Node current = head;
        System.out.println("Movies (Forward):");
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director + ", Year: " + current.year + ", Rating: " + current.rating);
            current = current.next;
        }
    }


    public void displayReverse() {
        if (tail == null) {
            System.out.println("No movies to display.");
            return;
        }
        Node current = tail;
        System.out.println("Movies (Reverse):");
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director + ", Year: " + current.year + ", Rating: " + current.rating);
            current = current.prev;
        }
    }

    public static void main(String[] args) {
        MovieManagementSystem mms = new MovieManagementSystem();
        mms.addAtEnd("Inception", "Christopher Nolan", 2010, 8.8);
        mms.addAtBeginning("The Matrix", "Lana Wachowski", 1999, 8.7);
        mms.addAtPosition("Interstellar", "Christopher Nolan", 2014, 8.6, 2);
        mms.displayForward();
        mms.displayReverse();
        mms.searchByDirector("Christopher Nolan");
        mms.searchByRating(8.7);
        mms.updateRating("The Matrix", 9.0);
        mms.displayForward();
        mms.removeByTitle("Inception");
        mms.displayForward();
    }
}
