import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter base in cm: ");
        double baseCm = input.nextDouble();
        System.out.print("Enter height in cm: ");
        double heightCm = input.nextDouble();

        double areaCm2 = 0.5 * baseCm * heightCm;
        double areaIn2 = areaCm2 / (2.54 * 2.54);

        System.out.println("The Area of the triangle in sq in is " + areaIn2 + " and sq cm is " + areaCm2);
        input.close();
    }
}
