package Day4_Methods;

import java.util.Scanner;

public class YoungestTallestFriends {
    public static int findYoungest(int[] ages) {
        int youngest = ages[0];
        for (int age : ages) {
            if (age < youngest) {
                youngest = age;
            }
        }
        return youngest;
    }

    public static int findTallest(int[] heights) {
        int tallest = heights[0];
        for (int height : heights) {
            if (height > tallest) {
                tallest = height;
            }
        }
        return tallest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[3];
        int[] heights = new int[3];

        System.out.println("Enter ages of Amar, Akbar, and Anthony:");
        for (int i = 0; i < 3; i++) {
            ages[i] = sc.nextInt();
        }

        System.out.println("Enter heights (in cm) of Amar, Akbar, and Anthony:");
        for (int i = 0; i < 3; i++) {
            heights[i] = sc.nextInt();
        }

        int youngest = findYoungest(ages);
        int tallest = findTallest(heights);

        System.out.println("Youngest age: " + youngest);
        System.out.println("Tallest height: " + tallest + " cm");
        sc.close();
    }
}
