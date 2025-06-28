package Day4_ObjectOrientedDesignPrinciples;

import java.util.*;


public class CompanyDepartments {

    static class Company {
        private String name;
        private List<Department> departments;

        public Company(String name) {
            this.name = name;
            this.departments = new ArrayList<>();
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

        public String getName() {
            return name;
        }

        public void deleteCompany() {
            
            departments.clear();
            System.out.println("Company " + name + " deleted along with all its departments and employees.");
        }
    }

    static class Department {
        private String name;
        private List<Employee> employees;

        public Department(String name) {
            this.name = name;
            this.employees = new ArrayList<>();
        }

        public void addEmployee(String empName) {
            employees.add(new Employee(empName));
        }

        public void removeEmployee(String empName) {
            employees.removeIf(e -> e.getName().equals(empName));
        }

        public List<Employee> getEmployees() {
            return employees;
        }

        public String getName() {
            return name;
        }
    }

    static class Employee {
        private String name;

        public Employee(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        System.out.println("Problem 3: Company and Departments (Composition)");
        Company company = new Company("Tech Solutions");

        company.addDepartment("IT");
        company.addDepartment("HR");

        for (Department d : company.getDepartments()) {
            if (d.getName().equals("IT")) {
                d.addEmployee("Alice");
                d.addEmployee("Bob");
            } else if (d.getName().equals("HR")) {
                d.addEmployee("Charlie");
            }
        }

        System.out.println("Departments and employees before deleting company:");
        for (Department d : company.getDepartments()) {
            System.out.println("Department: " + d.getName());
            for (Employee e : d.getEmployees()) {
                System.out.println("- Employee: " + e.getName());
            }
        }

        company.deleteCompany();

        System.out.println("Departments after deleting company:");
        System.out.println(company.getDepartments().size());
    }
}
