package Day4_ObjectOrientedDesignPrinciples;

import java.util.*;


public class UniversityFacultiesDepartments {

    static class University {
        private String name;
        private List<Department> departments;
        private List<Faculty> faculties;

        public University(String name) {
            this.name = name;
            this.departments = new ArrayList<>();
            this.faculties = new ArrayList<>();
        }

        public void addDepartment(String deptName) {
            departments.add(new Department(deptName));
        }

        public void removeDepartment(String deptName) {
            departments.removeIf(d -> d.getName().equals(deptName));
        }

        public List<Department> getDepartments() {
            return departments;
        }

        public void addFaculty(Faculty faculty) {
            faculties.add(faculty);
        }

        public void removeFaculty(Faculty faculty) {
            faculties.remove(faculty);
        }

        public List<Faculty> getFaculties() {
            return faculties;
        }

        public String getName() {
            return name;
        }

        public void deleteUniversity() {
            
            departments.clear();
            System.out.println("University " + name + " deleted along with all its departments.");
        }
    }

    static class Department {
        private String name;

        public Department(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    static class Faculty {
        private String name;

        public Faculty(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        System.out.println("Problem 2: University with Faculties and Departments");
        University uni = new University("Tech University");
        uni.addDepartment("Computer Science");
        uni.addDepartment("Mechanical Engineering");

        Faculty f1 = new Faculty("Dr. Smith");
        Faculty f2 = new Faculty("Dr. Johnson");

        uni.addFaculty(f1);
        uni.addFaculty(f2);

        System.out.println("Departments before deleting university:");
        for (Department d : uni.getDepartments()) {
            System.out.println("- " + d.getName());
        }

        uni.deleteUniversity();

        System.out.println("Departments after deleting university:");
        System.out.println(uni.getDepartments().size());

        System.out.println("Faculty members can exist independently:");
        System.out.println(f1.getName());
        System.out.println(f2.getName());
    }
}
