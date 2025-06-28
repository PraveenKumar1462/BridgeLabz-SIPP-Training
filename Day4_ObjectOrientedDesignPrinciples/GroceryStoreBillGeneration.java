package Day4_ObjectOrientedDesignPrinciples;

import java.util.*;


class Product {
    private String name;
    private double quantity;
    private double pricePerUnit;

    public Product(String name, double quantity, double pricePerUnit) {
        this.name = name;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    public String getName() {
        return name;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public double getTotalPrice() {
        return quantity * pricePerUnit;
    }
}


class Customer {
    private String name;
    private List<Product> products;

    public Customer(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getName() {
        return name;
    }
}


class BillGenerator {
    public static double calculateTotal(Customer customer) {
        double total = 0.0;
        for (Product p : customer.getProducts()) {
            total += p.getTotalPrice();
        }
        return total;
    }
}

public class GroceryStoreBillGeneration {
    public static void main(String[] args) {

        Customer alice = new Customer("Alice");
        alice.addProduct(new Product("Apples", 2.0, 3.0)); // 2 kg at $3 per kg
        alice.addProduct(new Product("Milk", 1.0, 2.0));   // 1 liter at $2 per liter


        System.out.println("Customer: " + alice.getName());
        System.out.println("Products purchased:");
        for (Product p : alice.getProducts()) {
            System.out.println("- " + p.getName() + " (" + p.getQuantity() + " units at $" + p.getPricePerUnit() + " per unit)");
        }


        double totalBill = BillGenerator.calculateTotal(alice);
        System.out.println("Total Bill: $" + totalBill);
    }
}
