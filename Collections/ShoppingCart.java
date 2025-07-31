import java.util.*;

public class ShoppingCart {

    private Map<String, Double> productPrices = new HashMap<>();
    private LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();

    public void addProduct(String product, double price) {
        productPrices.put(product, price);
    }

    public void addToCart(String product, int quantity) {
        if (productPrices.containsKey(product)) {
            cart.put(product, cart.getOrDefault(product, 0) + quantity);
        }
    }

    public void displayCartInOrderAdded() {
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String product = entry.getKey();
            int quantity = entry.getValue();
            double price = productPrices.get(product);
            System.out.println(product + " x" + quantity + " @ " + price);
        }
    }

    public void displayCartSortedByPrice() {
        TreeMap<Double, List<String>> priceMap = new TreeMap<>();
        for (String product : cart.keySet()) {
            double price = productPrices.get(product);
            priceMap.putIfAbsent(price, new ArrayList<>());
            priceMap.get(price).add(product);
        }

        for (Map.Entry<Double, List<String>> entry : priceMap.entrySet()) {
            double price = entry.getKey();
            for (String product : entry.getValue()) {
                int quantity = cart.get(product);
                System.out.println(product + " x" + quantity + " @ " + price);
            }
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Apple", 1.5);
        cart.addProduct("Banana", 1.0);
        cart.addProduct("Mango", 2.5);

        cart.addToCart("Apple", 2);
        cart.addToCart("Mango", 1);
        cart.addToCart("Banana", 3);

        System.out.println("Cart (in order added):");
        cart.displayCartInOrderAdded();

        System.out.println("\nCart (sorted by price):");
        cart.displayCartSortedByPrice();
    }
}
