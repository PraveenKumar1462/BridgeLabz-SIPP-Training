package Day6_EncapsulationPolymorphismInterfaceAndAbstractClass;

interface Discountable {
    void applyDiscount(double percent);
    String getDiscountDetails();
}

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    protected void setPrice(double price) { this.price = price; }

    public abstract double calculateTotalPrice();

    public String getItemDetails() {
        return "Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity;
    }
}

class VegItem extends FoodItem implements Discountable {
    private double discount = 0;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity() - discount;
    }

    @Override
    public void applyDiscount(double percent) {
        discount = getPrice() * getQuantity() * percent / 100;
    }

    @Override
    public String getDiscountDetails() {
        return "Veg Discount: " + discount;
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private double discount = 0;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        // 10% extra charge for non-veg
        double total = getPrice() * getQuantity() * 1.10;
        return total - discount;
    }

    @Override
    public void applyDiscount(double percent) {
        discount = getPrice() * getQuantity() * percent / 100;
    }

    @Override
    public String getDiscountDetails() {
        return "Non-Veg Discount: " + discount;
    }
}

public class OnlineFoodDeliverySystem {
    public static void processOrder(FoodItem[] items) {
        for (FoodItem item : items) {
            System.out.println(item.getItemDetails());
            System.out.println("Total Price: " + item.calculateTotalPrice());
            if (item instanceof Discountable) {
                System.out.println(((Discountable)item).getDiscountDetails());
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        FoodItem[] order = {
            new VegItem("Paneer Tikka", 200, 2),
            new NonVegItem("Chicken Curry", 300, 1)
        };
        ((Discountable)order[0]).applyDiscount(10);
        ((Discountable)order[1]).applyDiscount(5);
        processOrder(order);
    }
}