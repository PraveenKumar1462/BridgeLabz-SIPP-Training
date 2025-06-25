package Day4_Methods;

import java.util.Scanner;

public class MaxHandshakes {
    public static int calculateHandshakes(int numberOfStudents) {
        return (numberOfStudents * (numberOfStudents - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int numberOfStudents = sc.nextInt();

        if (numberOfStudents < 0) {
            System.out.println("Number of students cannot be negative.");
        } else {
            int handshakes = calculateHandshakes(numberOfStudents);
            System.out.println("Maximum number of handshakes: " + handshakes);
        }
        sc.close();
    }
}
