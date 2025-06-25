public class MovieTicket {
    private String movieName;
    private String seatNumber;
    private double price;

    public MovieTicket(String movieName) {
        this.movieName = movieName;
        this.seatNumber = null;
        this.price = 0.0;
    }

    public void bookTicket(String seatNumber, double price) {
        this.seatNumber = seatNumber;
        this.price = price;
        System.out.println("Ticket booked for movie: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: " + price);
    }

    public void displayTicketDetails() {
        System.out.println("Movie Name: " + movieName);
        System.out.println("Seat Number: " + (seatNumber != null ? seatNumber : "Not booked"));
        System.out.println("Price: " + price);
    }
}
