package Day4_ObjectOrientedDesignPrinciples;

import java.util.*;


public class HospitalDoctorsPatients {

    static class Hospital {
        private String name;
        private List<Doctor> doctors;
        private List<Patient> patients;

        public Hospital(String name) {
            this.name = name;
            this.doctors = new ArrayList<>();
            this.patients = new ArrayList<>();
        }

        public void addDoctor(Doctor doctor) {
            doctors.add(doctor);
        }

        public void addPatient(Patient patient) {
            patients.add(patient);
        }

        public List<Doctor> getDoctors() {
            return doctors;
        }

        public List<Patient> getPatients() {
            return patients;
        }

        public String getName() {
            return name;
        }
    }

    static class Doctor {
        private String name;
        private Set<Patient> patients;

        public Doctor(String name) {
            this.name = name;
            this.patients = new HashSet<>();
        }

        public void consult(Patient patient) {
            patients.add(patient);
            patient.addDoctor(this);
            System.out.println("Doctor " + name + " is consulting patient " + patient.getName());
        }

        public Set<Patient> getPatients() {
            return patients;
        }

        public String getName() {
            return name;
        }
    }

    static class Patient {
        private String name;
        private Set<Doctor> doctors;

        public Patient(String name) {
            this.name = name;
            this.doctors = new HashSet<>();
        }

        protected void addDoctor(Doctor doctor) {
            doctors.add(doctor);
        }

        public Set<Doctor> getDoctors() {
            return doctors;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        System.out.println("Problem 3: Hospital, Doctors, and Patients");
        Hospital hospital = new Hospital("City Hospital");
        Doctor doc1 = new Doctor("Dr. Adams");
        Doctor doc2 = new Doctor("Dr. Baker");
        Patient p1 = new Patient("John");
        Patient p2 = new Patient("Mary");

        hospital.addDoctor(doc1);
        hospital.addDoctor(doc2);
        hospital.addPatient(p1);
        hospital.addPatient(p2);

        doc1.consult(p1);
        doc1.consult(p2);
        doc2.consult(p1);

        System.out.println("Patients of Dr. Adams:");
        for (Patient p : doc1.getPatients()) {
            System.out.println("- " + p.getName());
        }

        System.out.println("Doctors of John:");
        for (Doctor d : p1.getDoctors()) {
            System.out.println("- " + d.getName());
        }
    }
}
