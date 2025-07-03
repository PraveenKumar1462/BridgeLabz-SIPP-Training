package Day6_EncapsulationPolymorphismInterfaceAndAbstractClass;

import java.util.ArrayList;
import java.util.List;

interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}

abstract class Patient {
    private int patientId;
    private String name;
    private int age;

    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public int getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }

    public abstract double calculateBill();

    public String getPatientDetails() {
        return "ID: " + patientId + ", Name: " + name + ", Age: " + age;
    }
}

class InPatient extends Patient implements MedicalRecord {
    private double roomCharge;
    private List<String> records = new ArrayList<>();

    public InPatient(int patientId, String name, int age, double roomCharge) {
        super(patientId, name, age);
        this.roomCharge = roomCharge;
    }

    @Override
    public double calculateBill() {
        return roomCharge * 5; // Assume 5 days
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
    }

    @Override
    public List<String> viewRecords() {
        return records;
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private List<String> records = new ArrayList<>();

    public OutPatient(int patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
    }

    @Override
    public List<String> viewRecords() {
        return records;
    }
}

public class HospitalPatientManagement {
    public static void main(String[] args) {
        Patient[] patients = {
            new InPatient(1, "Alice", 30, 2000),
            new OutPatient(2, "Bob", 40, 500)
        };
        ((MedicalRecord)patients[0]).addRecord("Admitted for surgery");
        ((MedicalRecord)patients[1]).addRecord("Consulted for fever");

        for (Patient p : patients) {
            System.out.println(p.getPatientDetails());
            System.out.println("Bill: " + p.calculateBill());
            System.out.println("Records: " + ((MedicalRecord)p).viewRecords());
            System.out.println();
        }
    }
}