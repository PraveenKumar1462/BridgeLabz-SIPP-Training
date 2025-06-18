package Day3_ArrayPractices;

import java.util.Scanner;

public class BMIForTeam {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int n = input.nextInt();

        double[] weight = new double[n];
        double[] height = new double[n];
        double[] bmi = new double[n];
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            weight[i] = input.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            height[i] = input.nextDouble();
        }

        for (int i = 0; i < n; i++) {
            double heightM = height[i] / 100.0;
            bmi[i] = weight[i] / (heightM * heightM);

            if (bmi[i] <= 18.4) {
                status[i] = "Underweight";
            } else if (bmi[i] <= 24.9) {
                status[i] = "Normal";
            } else if (bmi[i] <= 39.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        System.out.println("\nPerson\tHeight(cm)\tWeight(kg)\tBMI\t\tStatus");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d\t%.2f\t\t%.2f\t\t%.2f\t%s\n", i + 1, height[i], weight[i], bmi[i], status[i]);
        }

        input.close();
    }
}
