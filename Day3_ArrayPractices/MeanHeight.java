package Day3_ArrayPractices;

import java.util.Scanner;

public class MeanHeight {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] heights = new double[11];
        System.out.println("Enter heights of 11 players:");
        double sum = 0.0;
        for (int i = 0; i < 11; i++) {
            heights[i] = input.nextDouble();
            sum += heights[i];
        }
        double mean = sum / 11;
        System.out.println("Mean height of football team: " + mean);
        input.close();
    }
}
