public class ItemInventory {
    private String itemCode;
    private String itemName;
    private double price;

    public ItemInventory(String itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    public void displayItemDetails() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: $" + price);
    }

    public double calculateTotalCost(int quantity) {
        return price * quantity;
    }

    public static void main(String[] args) {
        ItemInventory item = new ItemInventory("A101", "Laptop", 750.00);
        item.displayItemDetails();
        int quantity = 3;
        System.out.println("Total cost for " + quantity + " items: $" + item.calculateTotalCost(quantity));
    }
}
