
package Workshop;
class Vehicle {
    String vehicleNumber;
    int capacity;
    String type;
    boolean isAvailable;

    Vehicle(String vehicleNumber, int capacity, String type) {
        this.vehicleNumber = vehicleNumber;
        this.capacity = capacity;
        this.type = type;
        this.isAvailable = true;
    }

    double calculateFare(double distance, double rate) {
        return 50 + (distance * rate);
    }

    boolean isAvailable() {
        return isAvailable;
    }

    void setAvailable(boolean available) {
        this.isAvailable = available;
    }
}

class Mini extends Vehicle {
    Mini(String vehicleNumber, int capacity) {
        super(vehicleNumber, capacity, "Mini");
    }
}

class Sedan extends Vehicle {
    Sedan(String vehicleNumber, int capacity) {
        super(vehicleNumber, capacity, "Sedan");
    }

    double calculateFare(double distance, double rate) {
        return 100 + (distance * rate);
    }
}

class SUV extends Vehicle {
    SUV(String vehicleNumber, int capacity) {
        super(vehicleNumber, capacity, "SUV");
    }

    double calculateFare(double distance, double rate) {
        return 150 + (distance * rate);
    }
}

class Driver {
    String name, licenseNumber;
    double rating;
    boolean isAvailable;

    Driver(String name, String licenseNumber, double rating) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.rating = rating;
        this.isAvailable = true;
    }

    boolean isAvailable() {
        return isAvailable;
    }

    void setAvailable(boolean available) {
        this.isAvailable = available;
    }
}

class RideService {
    Vehicle vehicle;
    Driver driver;

    RideService(Vehicle vehicle, Driver driver) {
        this.vehicle = vehicle;
        this.driver = driver;
    }

    boolean isRideAvailable() {
        return vehicle.isAvailable() && driver.isAvailable();
    }

    void bookRide() {
        if (isRideAvailable()) {
            vehicle.setAvailable(false);
            driver.setAvailable(false);
            System.out.println("Booked " + vehicle.vehicleNumber + " with driver " + driver.name);
        } else {
            System.out.println("Either vehicle or driver is not available for booking.");
        }
    }

    void endRide() {
        vehicle.setAvailable(true);
        driver.setAvailable(true);
        System.out.println("Ended " + vehicle.vehicleNumber + " with driver " + driver.name);
    }
}

public class CabbyGoApp {
    public static void main(String[] args) {
        Vehicle mini = new Mini("M123", 4);
        Vehicle sedan = new Sedan("S456", 4);
        Vehicle suv = new SUV("U789", 7);
        Driver driver1 = new Driver("Ram", "L123", 4.5);

        RideService ride1 = new RideService(mini, driver1);

        System.out.println("Mini available: " + mini.isAvailable());
        System.out.println("Driver available: " + driver1.isAvailable());

        ride1.bookRide();

        System.out.println("Mini available after booking: " + mini.isAvailable());
        System.out.println("Driver available after booking: " + driver1.isAvailable());

        ride1.endRide();

        System.out.println("Mini available after ending ride: " + mini.isAvailable());
        System.out.println("Driver available after ending ride: " + driver1.isAvailable());

        double distance = 10.0, rate = 5.0;
        System.out.println("Mini Fare: " + mini.calculateFare(distance, rate));
        System.out.println("Sedan Fare: " + sedan.calculateFare(distance, rate));
        System.out.println("SUV Fare: " + suv.calculateFare(distance, rate));
    }
}