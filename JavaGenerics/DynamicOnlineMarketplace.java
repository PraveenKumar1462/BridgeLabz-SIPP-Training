package JavaGenerics;

class BookCategory {}
class ClothingCategory {}
class GadgetCategory {}

class Product<T> {
    private T category;
    private double price;
    public Product(T category, double price) {
        this.category = category;
        this.price = price;
    }
    public T getCategory() { return category; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}

class MarketplaceUtils {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountedPrice = product.getPrice() * (1 - percentage / 100);
        product.setPrice(discountedPrice);
    }
}
