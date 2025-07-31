package Workshop;

import java.util.LinkedList;
import java.util.Queue;

abstract class Ticket {
    private String id;
    private String customer;

    public Ticket(String id, String customer) {
        this.id = id;
        this.customer = customer;
    }

    public String getId() {
        return id;
    }

    public String getCustomer() {
        return customer;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return "Ticket[id=" + id + ", customer=" + customer + ", type=" + getType() + "]";
    }
}

class ChatTicket extends Ticket {
    public ChatTicket(String id, String customer) {
        super(id, customer);
    }

    @Override
    public String getType() {
        return "Chat";
    }
}

class CallTicket extends Ticket {
    public CallTicket(String id, String customer) {
        super(id, customer);
    }

    @Override
    public String getType() {
        return "Call";
    }
}

class EmailTicket extends Ticket {
    public EmailTicket(String id, String customer) {
        super(id, customer);
    }

    @Override
    public String getType() {
        return "Email";
    }
}

public class CustomerServiceCallCentre {
    private Queue<Ticket> queue = new LinkedList<>();

    public void addTicket(Ticket ticket) {
        queue.offer(ticket);
        System.out.println("Added: " + ticket);
    }

    public Ticket processTicket() {
        Ticket ticket = queue.poll();
        if (ticket != null) {
            System.out.println("Processed: " + ticket);
        } else {
            System.out.println("No tickets to process.");
        }
        return ticket;
    }

    public static void main(String[] args) {
        CustomerServiceCallCentre centre = new CustomerServiceCallCentre();
        centre.addTicket(new ChatTicket("1", "Praveen"));
        centre.addTicket(new CallTicket("2", "Tarun"));
        centre.addTicket(new EmailTicket("3", "Nishant"));

        while (true) {
            Ticket t = centre.processTicket();
            if (t == null) break;
        }
    }
}
