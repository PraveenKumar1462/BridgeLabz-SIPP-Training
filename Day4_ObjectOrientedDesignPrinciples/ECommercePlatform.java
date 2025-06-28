package Day4_ObjectOrientedDesignPrinciples;

import java.util.*;


public class ECommercePlatform {

    static class Customer {
        private String name;
        private List<Order> orders;

        public Customer(String name) {
            this.name = name;
            this.orders = new ArrayList<>();
        }

        public void placeOrder(Order order) {
            orders.add(order);
        }

        public List<Order> getOrders() {
            return orders;
        }

        public String getName() {
            return name;
        }
    }

    static class Order {
        private String orderId;
        private List<Product> products;

        public Order(String orderId) {
            this.orderId = orderId;
            this.products = new ArrayList<>();
        }

        public void addProduct(Product product) {
            products.add(product);
        }

        public List<Product> getProducts() {
            return products;
        }

        public String getOrderId() {
            return orderId;
        }
    }

    static class Product {
        private String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }

    public static void main(String[] args) {
        System.out.println("Problem 4: E-commerce Platform with Orders, Customers, and Products");
        Customer customer = new Customer("Emma");
        Order order1 = new Order("ORD001");
        Product prod1 = new Product("Laptop", 1200.00);
        Product prod2 = new Product("Mouse", 25.50);

        order1.addProduct(prod1);
        order1.addProduct(prod2);

        customer.placeOrder(order1);

        System.out.println("Orders placed by " + customer.getName() + ":");
        for (Order o : customer.getOrders()) {
            System.out.println("Order ID: " + o.getOrderId());
            System.out.println("Products:");
            for (Product p : o.getProducts()) {
                System.out.println("- " + p.getName() + " ($" + p.getPrice() + ")");
            }
        }
    }
}
