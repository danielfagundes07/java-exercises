package ECommerce_Exercise.Orders;

public enum OrderStatus {
    PENDING("Order created, waiting for payment"),
    PAID("Payment received"),
    SHIPPED("Order shipped to customer"),
    DELIVERED("Order delivered successfully");

    private final String description;

    OrderStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
