package Day1_LambdaExpressions;

import java.util.*;

class Product {
    String name;
    double price;
    double rating;
    double discount;

    public Product(String name, double price, double rating, double discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return name + " (Price: " + price + ", Rating: " + rating + ", Discount: " + discount + "%)";
    }
}

public class CustomSortingECommerce {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 1200, 4.5, 10));
        products.add(new Product("Smartphone", 800, 4.7, 5));
        products.add(new Product("Tablet", 400, 4.2, 15));

        System.out.println("Sort by price:");
        products.sort((p1, p2) -> Double.compare(p1.price, p2.price));
        products.forEach(System.out::println);


        System.out.println("\nSort by rating:");
        products.sort((p1, p2) -> Double.compare(p2.rating, p1.rating));
        products.forEach(System.out::println);


        System.out.println("\nSort by discount:");
        products.sort((p1, p2) -> Double.compare(p2.discount, p1.discount));
        products.forEach(System.out::println);
    }
}
