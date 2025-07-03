package Day6_EncapsulationPolymorphismInterfaceAndAbstractClass;

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    private String policyNumber;

    public Vehicle(String vehicleNumber, String type, double rentalRate, String policyNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.policyNumber = policyNumber;
    }

    public String getVehicleNumber() { return vehicleNumber; }
    public String getType() { return type; }
    public double getRentalRate() { return rentalRate; }
    protected String getPolicyNumber() { return policyNumber; }

    public abstract double calculateRentalCost(int days);
}

class Car extends Vehicle implements Insurable {
    public Car(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Car", rentalRate, policyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return 1000;
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance Policy: " + getPolicyNumber();
    }
}

class Bike extends Vehicle implements Insurable {
    public Bike(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Bike", rentalRate, policyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 0.8;
    }

    @Override
    public double calculateInsurance() {
        return 300;
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance Policy: " + getPolicyNumber();
    }
}

class Truck extends Vehicle implements Insurable {
    public Truck(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Truck", rentalRate, policyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 1.5;
    }

    @Override
    public double calculateInsurance() {
        return 2000;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance Policy: " + getPolicyNumber();
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("CAR123", 1000, "POL123"),
            new Bike("BIKE456", 500, "POL456"),
            new Truck("TRUCK789", 2000, "POL789")
        };
        for (Vehicle v : vehicles) {
            System.out.println(v.getType() + " " + v.getVehicleNumber());
            System.out.println("Rental for 3 days: " + v.calculateRentalCost(3));
            System.out.println(((Insurable)v).getInsuranceDetails() + ", Insurance: " + ((Insurable)v).calculateInsurance());
            System.out.println();
        }
    }
}