package Day4_ObjectOrientedDesignPrinciples;

import java.util.*;


class Subject {
    private String name;
    private int marks;

    public Subject(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }
}

class Student {
    private String name;
    private List<Subject> subjects;

    public Student(String name) {
        this.name = name;
        this.subjects = new ArrayList<>();
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public String getName() {
        return name;
    }
}

class GradeCalculator {
    public static double calculateAverage(Student student) {
        List<Subject> subjects = student.getSubjects();
        if (subjects.isEmpty()) return 0.0;
        int total = 0;
        for (Subject s : subjects) {
            total += s.getMarks();
        }
        return (double) total / subjects.size();
    }

    public static String calculateGrade(double average) {
        if (average >= 90) return "A";
        else if (average >= 80) return "B";
        else if (average >= 70) return "C";
        else if (average >= 60) return "D";
        else return "F";
    }
}

public class SchoolResultsApplication {
    public static void main(String[] args) {

        Student john = new Student("John");
        john.addSubject(new Subject("Maths", 90));
        john.addSubject(new Subject("Science", 85));

        System.out.println("Student: " + john.getName());
        System.out.println("Subjects and Marks:");
        for (Subject s : john.getSubjects()) {
            System.out.println("- " + s.getName() + ": " + s.getMarks());
        }


        double average = GradeCalculator.calculateAverage(john);
        String grade = GradeCalculator.calculateGrade(average);
        System.out.println("Average Marks: " + average);
        System.out.println("Grade: " + grade);
    }
}
