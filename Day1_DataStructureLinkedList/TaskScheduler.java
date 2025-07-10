package Day1_DataStructureLinkedList;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class TaskScheduler {
    private static class Node {
        int taskId;
        String taskName;
        int priority;
        Date dueDate;
        Node next;

        Node(int taskId, String taskName, int priority, String dueDateStr) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.priority = priority;
            try {
                this.dueDate = new SimpleDateFormat("yyyy-MM-dd").parse(dueDateStr);
            } catch (ParseException e) {
                this.dueDate = null;
            }
            this.next = null;
        }
    }

    private Node head;
    private Node current;

    public TaskScheduler() {
        head = null;
        current = null;
    }


    public void addAtBeginning(int taskId, String taskName, int priority, String dueDateStr) {
        Node newNode = new Node(taskId, taskName, priority, dueDateStr);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
        } else {
            Node tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
    }

    public void addAtEnd(int taskId, String taskName, int priority, String dueDateStr) {
        Node newNode = new Node(taskId, taskName, priority, dueDateStr);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
        } else {
            Node tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            tail.next = newNode;
            newNode.next = head;
        }
    }


    public void addAtPosition(int taskId, String taskName, int priority, String dueDateStr, int position) {
        if (position <= 0) {
            System.out.println("Invalid position.");
            return;
        }
        if (position == 1) {
            addAtBeginning(taskId, taskName, priority, dueDateStr);
            return;
        }
        Node newNode = new Node(taskId, taskName, priority, dueDateStr);
        Node currentNode = head;
        int count = 1;
        while (count < position - 1 && currentNode.next != head) {
            currentNode = currentNode.next;
            count++;
        }
        if (count != position - 1) {
            System.out.println("Position out of bounds.");
            return;
        }
        newNode.next = currentNode.next;
        currentNode.next = newNode;
    }
    public void removeByTaskId(int taskId) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.taskId == taskId) {
            if (head.next == head) {
                head = null;
                current = null;
                System.out.println("Removed task with ID: " + taskId);
                return;
            }
            Node tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            head = head.next;
            tail.next = head;
            if (current.taskId == taskId) {
                current = head;
            }
            System.out.println("Removed task with ID: " + taskId);
            return;
        }
        Node prev = head;
        Node curr = head.next;
        while (curr != head && curr.taskId != taskId) {
            prev = curr;
            curr = curr.next;
        }
        if (curr == head) {
            System.out.println("Task with ID " + taskId + " not found.");
            return;
        }
        prev.next = curr.next;
        if (current.taskId == taskId) {
            current = curr.next;
        }
        System.out.println("Removed task with ID: " + taskId);
    }


    public void viewCurrentTask() {
        if (current == null) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("Current Task ID: " + current.taskId + ", Name: " + current.taskName + ", Priority: " + current.priority + ", Due Date: " + new SimpleDateFormat("yyyy-MM-dd").format(current.dueDate));
    }


    public void moveToNextTask() {
        if (current == null) {
            System.out.println("No tasks available.");
            return;
        }
        current = current.next;
        viewCurrentTask();
    }


    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }
        Node temp = head;
        System.out.println("Tasks:");
        do {
            System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + new SimpleDateFormat("yyyy-MM-dd").format(temp.dueDate));
            temp = temp.next;
        } while (temp != head);
    }


    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks to search.");
            return;
        }
        Node temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName + ", Due Date: " + new SimpleDateFormat("yyyy-MM-dd").format(temp.dueDate));
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) {
            System.out.println("No tasks found with priority: " + priority);
        }
    }

    public static void main(String[] args) {
        TaskScheduler ts = new TaskScheduler();
        ts.addAtEnd(1, "Task1", 1, "2024-07-01");
        ts.addAtBeginning(2, "Task2", 2, "2024-06-15");
        ts.addAtPosition(3, "Task3", 1, "2024-06-20", 2);
        ts.displayAllTasks();
        ts.viewCurrentTask();
        ts.moveToNextTask();
        ts.searchByPriority(1);
        ts.removeByTaskId(2);
        ts.displayAllTasks();
    }
}
