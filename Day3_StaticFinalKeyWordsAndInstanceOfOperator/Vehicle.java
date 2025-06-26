package Day3_StaticFinalKeyWordsAndInstanceOfOperator;

public class Vehicle {
    private static double registrationFee = 1000.0;
    private final String registrationNumber;
    private String ownerName;
    private String vehicleType;

    public Vehicle(String registrationNumber, String ownerName, String vehicleType) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }


    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }


    public void displayRegistrationDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Registration Number: " + registrationNumber +
                ", Owner: " + ownerName +
                ", Vehicle Type: " + vehicleType +
                ", Registration Fee: " + registrationFee);
        } else {
            System.out.println("Not a valid Vehicle object.");
        }
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("MH12AB1234", "Alice", "Car");
        Vehicle v2 = new Vehicle("MH14XY5678", "Bob", "Bike");

        v1.displayRegistrationDetails();
        v2.displayRegistrationDetails();

        Vehicle.updateRegistrationFee(1500.0);

        v1.displayRegistrationDetails();
    }
}