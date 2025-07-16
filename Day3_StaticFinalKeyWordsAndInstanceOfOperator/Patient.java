package Day3_StaticFinalKeyWordsAndInstanceOfOperator;

public class Patient {
    private static String hospitalName = "BridgeLabz Hospital";
    private static int totalPatients = 0;

    private final int patientID;
    private String name;
    private int age;
    private String ailment;

    public Patient(int patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }


    public static void getTotalPatients() {
        System.out.println("Total Patients: " + totalPatients);
    }


    public void displayPatientDetails() {
        if (this instanceof Patient) {
            System.out.println("Patient ID: " + patientID +
                ", Name: " + name +
                ", Age: " + age +
                ", Ailment: " + ailment +
                ", Hospital: " + hospitalName);
        } else {
            System.out.println("Not a valid Patient object.");
        }
    }

    public static void main(String[] args) {
        Patient p1 = new Patient(1, "Alice", 30, "Fever");
        Patient p2 = new Patient(2, "Bob", 45, "Diabetes");

        p1.displayPatientDetails();
        p2.displayPatientDetails();

        Patient.getTotalPatients();
    }
}