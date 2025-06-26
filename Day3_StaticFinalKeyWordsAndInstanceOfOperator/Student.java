package Day3_StaticFinalKeyWordsAndInstanceOfOperator;

public class Student {
    private static String universityName = "BridgeLabz University";
    private static int totalStudents = 0;

    private final int rollNumber;
    private String name;
    private String grade;

    public Student(int rollNumber, String name, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }


    public static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }


    public void displayStudentDetails() {
        if (this instanceof Student) {
            System.out.println("Roll Number: " + rollNumber + ", Name: " + name +
                ", Grade: " + grade + ", University: " + universityName);
        } else {
            System.out.println("Not a valid Student object.");
        }
    }


    public void updateGrade(String newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
            System.out.println("Grade updated for " + name + " to " + grade);
        } else {
            System.out.println("Not a valid Student object.");
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student(101, "Alice", "A");
        Student s2 = new Student(102, "Bob", "B");

        s1.displayStudentDetails();
        s2.displayStudentDetails();

        Student.displayTotalStudents();

        s2.updateGrade("A+");
        s2.displayStudentDetails();
    }
}