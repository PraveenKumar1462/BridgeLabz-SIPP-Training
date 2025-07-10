package Day1_DataStructureLinkedList;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class OnlineTicketReservation {
    private static class Node {
        int ticketId;
        String customerName;
        String movieName;
        String seatNumber;
        Date bookingTime;
        Node next;

        Node(int ticketId, String customerName, String movieName, String seatNumber, String bookingTimeStr) {
            this.ticketId = ticketId;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            try {
                this.bookingTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(bookingTimeStr);
            } catch (ParseException e) {
                this.bookingTime = null;
            }
            this.next = null;
        }
    }

    private Node head;

    public OnlineTicketReservation() {
        head = null;
    }


    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTimeStr) {
        Node newNode = new Node(ticketId, customerName, movieName, seatNumber, bookingTimeStr);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }
        Node tail = head;
        while (tail.next != head) {
            tail = tail.next;
        }
        tail.next = newNode;
        newNode.next = head;
    }

    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }
        if (head.ticketId == ticketId) {
            if (head.next == head) {
                head = null;
                System.out.println("Removed ticket with ID: " + ticketId);
                return;
            }
            Node tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            head = head.next;
            tail.next = head;
            System.out.println("Removed ticket with ID: " + ticketId);
            return;
        }
        Node prev = head;
        Node curr = head.next;
        while (curr != head && curr.ticketId != ticketId) {
            prev = curr;
            curr = curr.next;
        }
        if (curr == head) {
            System.out.println("Ticket with ID " + ticketId + " not found.");
            return;
        }
        prev.next = curr.next;
        System.out.println("Removed ticket with ID: " + ticketId);
    }


    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets to display.");
            return;
        }
        Node temp = head;
        System.out.println("Tickets:");
        do {
            System.out.println("Ticket ID: " + temp.ticketId + ", Customer: " + temp.customerName + ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Booking Time: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(temp.bookingTime));
            temp = temp.next;
        } while (temp != head);
    }


    public void searchTicket(String query) {
        if (head == null) {
            System.out.println("No tickets to search.");
            return;
        }
        Node temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(query) || temp.movieName.equalsIgnoreCase(query)) {
                System.out.println("Ticket ID: " + temp.ticketId + ", Customer: " + temp.customerName + ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Booking Time: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(temp.bookingTime));
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) {
            System.out.println("No tickets found for query: " + query);
        }
    }


    public int totalTickets() {
        if (head == null) {
            return 0;
        }
        int count = 0;
        Node temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }


    public static void main(String[] args) {
        OnlineTicketReservation otr = new OnlineTicketReservation();
        otr.addTicket(1, "Alice", "Inception", "A1", "2024-06-01 10:00:00");
        otr.addTicket(2, "Bob", "Interstellar", "B2", "2024-06-01 10:05:00");
        otr.addTicket(3, "Charlie", "Inception", "A2", "2024-06-01 10:10:00");
        otr.displayTickets();
        otr.searchTicket("Inception");
        System.out.println("Total tickets booked: " + otr.totalTickets());
        otr.removeTicket(2);
        otr.displayTickets();
    }
}
