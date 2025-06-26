public class EmployeeRecords {
    public int employeeID;
    protected String department;
    private double salary;

    public EmployeeRecords(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }


    public void setSalary(double salary) {
        this.salary = salary;
    }


    public double getSalary() {
        return salary;
    }

    public void displayEmployee() {
        System.out.println("Employee ID: " + employeeID + ", Department: " + department + ", Salary: " + salary);
    }
}


class Manager extends EmployeeRecords {
    private String level;

    public Manager(int employeeID, String department, double salary, String level) {
        super(employeeID, department, salary);
        this.level = level;
    }

    public void displayManager() {

        System.out.println("Manager ID: " + employeeID + ", Department: " + department + ", Level: " + level + ", Salary: " + getSalary());
    }

    public static void main(String[] args) {
        EmployeeRecords emp = new EmployeeRecords(101, "HR", 50000.0);
        emp.displayEmployee();
        emp.setSalary(55000.0);
        emp.displayEmployee();

        Manager mgr = new Manager(201, "IT", 80000.0, "Senior");
        mgr.displayManager();
    }
}