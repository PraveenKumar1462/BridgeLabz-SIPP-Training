import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static int generateGuess(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    private static String getUserFeedback(Scanner scanner, int guess) {
        System.out.println("Is your number " + guess + "? (high/low/correct): ");
        return scanner.nextLine().trim().toLowerCase();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = 1;
        int max = 100;
        String feedback = "";
        int guess;

        System.out.println("Think of a number between 1 and 100, and I will try to guess it.");

        while (!feedback.equals("correct")) {
            guess = generateGuess(min, max);
            feedback = getUserFeedback(scanner, guess);

            if (feedback.equals("high")) {
                max = guess - 1;
            } else if (feedback.equals("low")) {
                min = guess + 1;
            } else if (!feedback.equals("correct")) {
                System.out.println("Invalid input. Please enter 'high', 'low', or 'correct'.");
            }

            if (min > max) {
                System.out.println("There seems to be a contradiction in your feedback. Please restart the game.");
                break;
            }
        }

        if (feedback.equals("correct")) {
            System.out.println("Yay! I guessed your number.");
        }

        scanner.close();
    }
}
