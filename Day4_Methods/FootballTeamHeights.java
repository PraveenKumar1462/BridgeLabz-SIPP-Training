package Day4_Methods;

import java.util.Random;

public class FootballTeamHeights {
    public static int sum(int[] heights) {
        int total = 0;
        for (int height : heights) {
            total += height;
        }
        return total;
    }

    public static double mean(int[] heights) {
        return (double) sum(heights) / heights.length;
    }

    public static int shortest(int[] heights) {
        int min = heights[0];
        for (int height : heights) {
            if (height < min) {
                min = height;
            }
        }
        return min;
    }

    public static int tallest(int[] heights) {
        int max = heights[0];
        for (int height : heights) {
            if (height > max) {
                max = height;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] heights = new int[11];
        Random rand = new Random();

        for (int i = 0; i < heights.length; i++) {
            heights[i] = 150 + rand.nextInt(101); // 150 to 250 cm
        }

        System.out.print("Heights of players: ");
        for (int height : heights) {
            System.out.print(height + " ");
        }
        System.out.println();

        System.out.println("Sum of heights: " + sum(heights));
        System.out.printf("Mean height: %.2f cm%n", mean(heights));
        System.out.println("Shortest height: " + shortest(heights) + " cm");
        System.out.println("Tallest height: " + tallest(heights) + " cm");
    }
}
