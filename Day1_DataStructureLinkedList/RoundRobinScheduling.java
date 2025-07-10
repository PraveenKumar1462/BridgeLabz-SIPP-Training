package Day1_DataStructureLinkedList;

import java.util.LinkedList;
import java.util.Queue;

public class RoundRobinScheduling {
    private static class Node {
        int processId;
        int burstTime;
        int priority;
        Node next;

        Node(int processId, int burstTime, int priority) {
            this.processId = processId;
            this.burstTime = burstTime;
            this.priority = priority;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public RoundRobinScheduling() {
        head = null;
        tail = null;
    }


    public void addProcess(int processId, int burstTime, int priority) {
        Node newNode = new Node(processId, burstTime, priority);
        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
    }


    public void removeProcess(int processId) {
        if (head == null) {
            System.out.println("No processes to remove.");
            return;
        }
        if (head.processId == processId) {
            if (head == tail) {
                head = tail = null;
                return;
            }
            tail.next = head.next;
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != tail && current.next.processId != processId) {
            current = current.next;
        }
        if (current.next.processId == processId) {
            if (current.next == tail) {
                tail = current;
            }
            current.next = current.next.next;
        } else {
            System.out.println("Process ID " + processId + " not found.");
        }
    }


    public void simulateScheduling(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }
        Node current = head;
        Queue<Integer> completionQueue = new LinkedList<>();
        int time = 0;
        int totalProcesses = 0;
        Node temp = head;
        do {
            totalProcesses++;
            temp = temp.next;
        } while (temp != head);

        int[] remainingBurst = new int[totalProcesses];
        int[] waitingTime = new int[totalProcesses];
        int[] turnaroundTime = new int[totalProcesses];
        int index = 0;
        temp = head;
        do {
            remainingBurst[index++] = temp.burstTime;
            temp = temp.next;
        } while (temp != head);

        boolean done;
        do {
            done = true;
            index = 0;
            temp = head;
            do {
                if (remainingBurst[index] > 0) {
                    done = false;
                    if (remainingBurst[index] > timeQuantum) {
                        time += timeQuantum;
                        remainingBurst[index] -= timeQuantum;
                    } else {
                        time += remainingBurst[index];
                        waitingTime[index] = time - temp.burstTime;
                        turnaroundTime[index] = time;
                        remainingBurst[index] = 0;
                        completionQueue.add(temp.processId);
                    }
                }
                temp = temp.next;
                index++;
            } while (temp != head);
            displayProcesses();
        } while (!done);

        double totalWaiting = 0;
        double totalTurnaround = 0;
        for (int i = 0; i < totalProcesses; i++) {
            totalWaiting += waitingTime[i];
            totalTurnaround += turnaroundTime[i];
        }
        System.out.println("Average Waiting Time: " + (totalWaiting / totalProcesses));
        System.out.println("Average Turnaround Time: " + (totalTurnaround / totalProcesses));
    }


    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes to display.");
            return;
        }
        Node current = head;
        System.out.println("Processes in Circular Queue:");
        do {
            System.out.println("Process ID: " + current.processId + ", Burst Time: " + current.burstTime + ", Priority: " + current.priority);
            current = current.next;
        } while (current != head);
    }


    public static void main(String[] args) {
        RoundRobinScheduling rrs = new RoundRobinScheduling();
        rrs.addProcess(1, 10, 1);
        rrs.addProcess(2, 5, 2);
        rrs.addProcess(3, 8, 1);
        rrs.displayProcesses();
        rrs.simulateScheduling(3);
        rrs.removeProcess(2);
        rrs.displayProcesses();
    }
}
