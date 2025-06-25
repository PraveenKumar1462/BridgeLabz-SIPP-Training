package Day5_String;

import java.util.Random;

public class StudentGradeCalculator {

    
    public static int[][] generateScores(int numStudents) {
        Random rand = new Random();
        int[][] scores = new int[numStudents][3];
        for (int i = 0; i < numStudents; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = 40 + rand.nextInt(61);
            }
        }
        return scores;
    }

    public static double[][] calculateTotals(int[][] scores) {
        int numStudents = scores.length;
        double[][] totals = new double[numStudents][3];
        for (int i = 0; i < numStudents; i++) {
            int total = 0;
            for (int j = 0; j < 3; j++) {
                total += scores[i][j];
            }
            double average = total / 3.0;
            double percentage = Math.round((average) * 100.0) / 100.0;
            totals[i][0] = total;
            totals[i][1] = average;
            totals[i][2] = percentage;
        }
        return totals;
    }

    
    public static String[] calculateGrades(double[][] totals) {
        int numStudents = totals.length;
        String[] grades = new String[numStudents];
        for (int i = 0; i < numStudents; i++) {
            double percentage = totals[i][2];
            if (percentage >= 80) {
                grades[i] = "A";
            } else if (percentage >= 70) {
                grades[i] = "B";
            } else if (percentage >= 60) {
                grades[i] = "C";
            } else if (percentage >= 50) {
                grades[i] = "D";
            } else if (percentage >= 40) {
                grades[i] = "E";
            } else {
                grades[i] = "R";
            }
        }
        return grades;
    }


    public static void displayScorecard(int[][] scores, double[][] totals, String[] grades) {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s%n",
                "Student", "Physics", "Chemistry", "Maths", "Total", "Average", "Percent", "Grade");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-10d %-10d %-10d %-10d %-10.0f %-10.2f %-10.2f %-10s%n",
                    i + 1, scores[i][0], scores[i][1], scores[i][2],
                    totals[i][0], totals[i][1], totals[i][2], grades[i]);
        }
    }

    public static void main(String[] args) {
        int numStudents = 5;
        int[][] scores = generateScores(numStudents);
        double[][] totals = calculateTotals(scores);
        String[] grades = calculateGrades(totals);
        displayScorecard(scores, totals, grades);
    }
}
