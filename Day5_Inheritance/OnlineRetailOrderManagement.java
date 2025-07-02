package Day5_Inheritance;

import java.time.LocalDate;

class OnlineRetailOrderManagement {
    protected String orderId;
    protected LocalDate orderDate;

    public OnlineRetailOrderManagement(String orderId, LocalDate orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return "Order placed";
    }
}

class ShippedOrder extends OnlineRetailOrderManagement {
    protected String trackingNumber;

    public ShippedOrder(String orderId, LocalDate orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    public String getOrderStatus() {
        return "Order shipped, Tracking Number: " + trackingNumber;
    }
}

class DeliveredOrder extends ShippedOrder {
    private LocalDate deliveryDate;

    public DeliveredOrder(String orderId, LocalDate orderDate, String trackingNumber, LocalDate deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String getOrderStatus() {
        return "Order delivered on " + deliveryDate;
    }

    public static void main(String[] args) {
        OnlineRetailOrderManagement order = new OnlineRetailOrderManagement("ORD123", LocalDate.of(2025, 7, 1));
        ShippedOrder shipped = new ShippedOrder("ORD124", LocalDate.of(2025, 7, 2), "TRK987654");
        DeliveredOrder delivered = new DeliveredOrder("ORD125", LocalDate.of(2025, 7, 3), "TRK123456", LocalDate.of(2025, 7, 5));

        System.out.println(order.getOrderStatus());
        System.out.println(shipped.getOrderStatus());
        System.out.println(delivered.getOrderStatus());
    }
}