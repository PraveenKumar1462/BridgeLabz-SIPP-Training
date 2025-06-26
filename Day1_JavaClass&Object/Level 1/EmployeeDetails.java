public class EmployeeDetails {
    private String name;
    private int id;
    private double salary;

    public EmployeeDetails(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Salary: " + salary);
    }

    public static void main(String[] args) {
        EmployeeDetails emp = new EmployeeDetails("John Doe", 101, 50000.0);
        emp.displayDetails();
    }
}
