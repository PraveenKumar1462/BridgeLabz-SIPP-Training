package Day5_Inheritance;

public class SmartHomeDevice {
    protected String deviceId;
    protected String status;

    public SmartHomeDevice(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    public void displayStatus() {
        System.out.println("Device ID: " + deviceId + ", Status: " + status);
    }
}

class Thermostat extends SmartHomeDevice {
    private double temperatureSetting;

    public Thermostat(String deviceId, String status, double temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    @Override
    public void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }

    public static void main(String[] args) {
        Thermostat thermostat = new Thermostat("TH-001", "ON", 22.5);
        thermostat.displayStatus();
    }
}