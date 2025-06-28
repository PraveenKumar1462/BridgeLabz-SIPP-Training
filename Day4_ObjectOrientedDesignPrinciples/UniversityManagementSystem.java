package Day4_ObjectOrientedDesignPrinciples;

import java.util.*;


public class UniversityManagementSystem {

    static class UMStudent {
        private String name;
        private Set<UMCourse> courses;

        public UMStudent(String name) {
            this.name = name;
            this.courses = new HashSet<>();
        }

        public void enrollCourse(UMCourse course) {
            courses.add(course);
            course.addStudent(this);
        }

        public Set<UMCourse> getCourses() {
            return courses;
        }

        public String getName() {
            return name;
        }
    }

    static class UMProfessor {
        private String name;
        private Set<UMCourse> courses;

        public UMProfessor(String name) {
            this.name = name;
            this.courses = new HashSet<>();
        }

        public void assignProfessor(UMCourse course) {
            courses.add(course);
            course.setProfessor(this);
        }

        public Set<UMCourse> getCourses() {
            return courses;
        }

        public String getName() {
            return name;
        }
    }

    static class UMCourse {
        private String name;
        private UMProfessor professor;
        private Set<UMStudent> students;

        public UMCourse(String name) {
            this.name = name;
            this.students = new HashSet<>();
        }

        protected void addStudent(UMStudent student) {
            students.add(student);
        }

        protected void setProfessor(UMProfessor professor) {
            this.professor = professor;
        }

        public String getName() {
            return name;
        }

        public UMProfessor getProfessor() {
            return professor;
        }

        public Set<UMStudent> getStudents() {
            return students;
        }
    }

    public static void main(String[] args) {
        System.out.println("Problem 5: University Management System");
        UMStudent umStudent = new UMStudent("David");
        UMProfessor umProfessor = new UMProfessor("Dr. Green");
        UMCourse umCourse = new UMCourse("Physics");

        umStudent.enrollCourse(umCourse);
        umProfessor.assignProfessor(umCourse);

        System.out.println("Courses enrolled by " + umStudent.getName() + ":");
        for (UMCourse c : umStudent.getCourses()) {
            System.out.println("- " + c.getName());
        }

        System.out.println("Professor teaching " + umCourse.getName() + ": " + umCourse.getProfessor().getName());
    }
}
