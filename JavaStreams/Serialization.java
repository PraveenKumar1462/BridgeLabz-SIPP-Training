import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    int id;
    String name;
    String department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary + '}';
    }
}

public class Serialization {
    public static void main(String[] args) {
        String filename = "employees.ser";

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Alice", "HR", 50000));
        employees.add(new Employee(2, "Bob", "IT", 60000));
        employees.add(new Employee(3, "Charlie", "Finance", 55000));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized to " + filename);
        } catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
        }


        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            List<Employee> deserializedEmployees = (List<Employee>) ois.readObject();
            System.out.println("Deserialized Employees:");
            for (Employee emp : deserializedEmployees) {
                System.out.println(emp);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization error: " + e.getMessage());
        }
    }
}
