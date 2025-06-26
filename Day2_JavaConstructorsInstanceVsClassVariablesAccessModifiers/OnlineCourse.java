public class OnlineCourse {
    private String productName;
    private double price;
    private static int totalProducts = 0;

    public OnlineCourse(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }

    public void displayProductDetails() {
        System.out.println("Product Name: " + productName + ", Price: " + price);
    }

    public static void displayTotalProducts() {
        System.out.println("Total Products: " + totalProducts);
    }

    public static void main(String[] args) {
        OnlineCourse p1 = new OnlineCourse("Laptop", 50000);
        OnlineCourse p2 = new OnlineCourse("Smartphone", 20000);

        p1.displayProductDetails();
        p2.displayProductDetails();

        OnlineCourse.displayTotalProducts();
    }
}