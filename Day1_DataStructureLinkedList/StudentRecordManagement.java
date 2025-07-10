package Day1_DataStructureLinkedList;

public class StudentRecordManagement {
    private static class Node {
        int rollNumber;
        String name;
        int age;
        String grade;
        Node next;

        Node(int rollNumber, String name, int age, String grade) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.age = age;
            this.grade = grade;
            this.next = null;
        }
    }

    private Node head;

    public StudentRecordManagement() {
        head = null;
    }

    
    public void addAtBeginning(int rollNumber, String name, int age, String grade) {
        Node newNode = new Node(rollNumber, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    public void addAtEnd(int rollNumber, String name, int age, String grade) {
        Node newNode = new Node(rollNumber, name, age, grade);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }


    public void addAtPosition(int rollNumber, String name, int age, String grade, int position) {
        if (position <= 0) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            addAtBeginning(rollNumber, name, age, grade);
            return;
        }
        Node newNode = new Node(rollNumber, name, age, grade);
        Node current = head;
        for (int i = 1; i < position - 1; i++) {
            if (current == null) {
                System.out.println("Position out of bounds.");
                return;
            }
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of bounds.");
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }


    public void deleteByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.rollNumber == rollNumber) {
            head = head.next;
            System.out.println("Deleted student with Roll Number: " + rollNumber);
            return;
        }
        Node current = head;
        while (current.next != null && current.next.rollNumber != rollNumber) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
            return;
        }
        current.next = current.next.next;
        System.out.println("Deleted student with Roll Number: " + rollNumber);
    }


    public Node searchByRollNumber(int rollNumber) {
        Node current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                return current;
            }
            current = current.next;
        }
        return null;
    }


    public void updateGrade(int rollNumber, String newGrade) {
        Node student = searchByRollNumber(rollNumber);
        if (student == null) {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
            return;
        }
        student.grade = newGrade;
        System.out.println("Updated grade for Roll Number " + rollNumber + " to " + newGrade);
    }


    public void displayAll() {
        if (head == null) {
            System.out.println("No student records to display.");
            return;
        }
        Node current = head;
        System.out.println("Student Records:");
        while (current != null) {
            System.out.println("Roll Number: " + current.rollNumber + ", Name: " + current.name + ", Age: " + current.age + ", Grade: " + current.grade);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        StudentRecordManagement srm = new StudentRecordManagement();
        srm.addAtEnd(1, "Alice", 20, "A");
        srm.addAtBeginning(2, "Bob", 21, "B");
        srm.addAtPosition(3, "Charlie", 19, "C", 2);
        srm.displayAll();
        srm.updateGrade(2, "A+");
        srm.displayAll();
        srm.deleteByRollNumber(1);
        srm.displayAll();
        Node found = srm.searchByRollNumber(3);
        if (found != null) {
            System.out.println("Found student: " + found.name);
        } else {
            System.out.println("Student not found.");
        }
    }
}