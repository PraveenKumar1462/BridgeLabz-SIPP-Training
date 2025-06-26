public class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }


    public double getCGPA() {
        return CGPA;
    }


    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    public void displayStudent() {
        System.out.println("Roll Number: " + rollNumber + ", Name: " + name + ", CGPA: " + CGPA);
    }
}


class PostgraduateStudent extends Student {
    private String specialization;

    public PostgraduateStudent(int rollNumber, String name, double CGPA, String specialization) {
        super(rollNumber, name, CGPA);
        this.specialization = specialization;
    }

    public void displayPostgraduateStudent() {
        
        System.out.println("Roll Number: " + rollNumber + ", Name: " + name + ", Specialization: " + specialization + ", CGPA: " + getCGPA());
    }

    public static void main(String[] args) {
        Student s1 = new Student(101, "Alice", 8.7);
        s1.displayStudent();
        s1.setCGPA(9.0);
        s1.displayStudent();

        PostgraduateStudent pg = new PostgraduateStudent(201, "Bob", 9.2, "Computer Science");
        pg.displayPostgraduateStudent();
    }
}