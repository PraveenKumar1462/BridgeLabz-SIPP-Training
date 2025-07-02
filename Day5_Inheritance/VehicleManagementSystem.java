package Day5_Inheritance;


class VehicleManagementSystem {
    protected String model;
    protected int maxSpeed;

    public VehicleManagementSystem(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public void displayInfo() {
        System.out.println("Model: " + model + ", Max Speed: " + maxSpeed + " km/h");
    }
}


interface Refuelable {
    void refuel();
}


class ElectricVehicle extends VehicleManagementSystem {
    private int batteryCapacity;

    public ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    public void charge() {
        System.out.println(model + " is charging. Battery capacity: " + batteryCapacity + " kWh");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Electric Vehicle, Battery Capacity: " + batteryCapacity + " kWh");
    }
}


class PetrolVehicle extends VehicleManagementSystem implements Refuelable {
    private int fuelTankCapacity;

    public PetrolVehicle(String model, int maxSpeed, int fuelTankCapacity) {
        super(model, maxSpeed);
        this.fuelTankCapacity = fuelTankCapacity;
    }

    @Override
    public void refuel() {
        System.out.println(model + " is refueling. Fuel tank capacity: " + fuelTankCapacity + " liters");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Petrol Vehicle, Fuel Tank Capacity: " + fuelTankCapacity + " liters");
    }
}


class TestVehicleSystem {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle("Tesla Model 3", 225, 75);
        PetrolVehicle pv = new PetrolVehicle("Honda City", 180, 40);

        ev.displayInfo();
        ev.charge();
        System.out.println();

        pv.displayInfo();
        pv.refuel();
    }
}