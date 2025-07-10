package Day4_ObjectOrientedDesignPrinciples;

import java.util.*;


public class SchoolStudentsCourses {

    static class School {
        private String name;
        private List<Student> students;

        public School(String name) {
            this.name = name;
            this.students = new ArrayList<>();
        }

        public void addStudent(Student student) {
            students.add(student);
        }

        public void removeStudent(Student student) {
            students.remove(student);
        }

        public List<Student> getStudents() {
            return students;
        }

        public String getName() {
            return name;
        }
    }

    static class Student {
        private String name;
        private Set<Course> courses;

        public Student(String name) {
            this.name = name;
            this.courses = new HashSet<>();
        }

        public void enrollCourse(Course course) {
            courses.add(course);
            course.addStudent(this);
        }

        public void dropCourse(Course course) {
            courses.remove(course);
            course.removeStudent(this);
        }

        public Set<Course> getCourses() {
            return courses;
        }

        public String getName() {
            return name;
        }

        public void viewCourses() {
            System.out.println("Courses enrolled by " + name + ":");
            for (Course c : courses) {
                System.out.println("- " + c.getName());
            }
        }
    }

    static class Course {
        private String name;
        private Set<Student> students;

        public Course(String name) {
            this.name = name;
            this.students = new HashSet<>();
        }

        protected void addStudent(Student student) {
            students.add(student);
        }

        protected void removeStudent(Student student) {
            students.remove(student);
        }

        public Set<Student> getStudents() {
            return students;
        }

        public String getName() {
            return name;
        }

        public void showEnrolledStudents() {
            System.out.println("Students enrolled in " + name + ":");
            for (Student s : students) {
                System.out.println("- " + s.getName());
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Problem 1: School and Students with Courses");
        School school = new School("Greenwood High");
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");
        school.addStudent(s1);
        school.addStudent(s2);

        Course math = new Course("Mathematics");
        Course science = new Course("Science");

        s1.enrollCourse(math);
        s1.enrollCourse(science);
        s2.enrollCourse(science);

        s1.viewCourses();
        s2.viewCourses();

        math.showEnrolledStudents();
        science.showEnrolledStudents();
    }
}
