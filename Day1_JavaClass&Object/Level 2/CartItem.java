public class CartItem {
    private String itemName;
    private double price;
    private int quantity;

    public CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public void addItem(int quantity) {
        if (quantity > 0) {
            this.quantity += quantity;
            System.out.println(quantity + " " + itemName + "(s) added to the cart.");
        } else {
            System.out.println("Invalid quantity to add.");
        }
    }

    public void removeItem(int quantity) {
        if (quantity > 0) {
            if (this.quantity >= quantity) {
                this.quantity -= quantity;
                System.out.println(quantity + " " + itemName + "(s) removed from the cart.");
            } else {
                System.out.println("Cannot remove more items than present in the cart.");
            }
        } else {
            System.out.println("Invalid quantity to remove.");
        }
    }

    public void displayTotalCost() {
        double totalCost = price * quantity;
        System.out.println("Total cost for " + itemName + ": " + totalCost);
    }
}
