package Day3_StaticFinalKeyWordsAndInstanceOfOperator;

public class Product {
    private static double discount = 10.0;
    private final int productID;
    private String productName;
    private double price;
    private int quantity;

    public Product(int productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }


    public void displayProductDetails() {
        if (this instanceof Product) {
            System.out.println("Product ID: " + productID + ", Name: " + productName +
                ", Price: " + price + ", Quantity: " + quantity +
                ", Discount: " + discount + "%");
        } else {
            System.out.println("Not a valid Product object.");
        }
    }

    public static void main(String[] args) {
        Product p1 = new Product(1, "Laptop", 50000, 2);
        Product p2 = new Product(2, "Mouse", 500, 5);

        p1.displayProductDetails();
        p2.displayProductDetails();

        Product.updateDiscount(15.0);

        p1.displayProductDetails();
        p2.displayProductDetails();
    }
}