package ECommerce_Exercise.Orders;

import java.util.HashMap;

import ECommerce_Exercise.Product;
import ECommerce_Exercise.Taxable;
import ECommerce_Exercise.Discounts.Discount;
import ECommerce_Exercise.Shipping.ShippingEstimate;

public class Order implements Taxable {
    private Discount discount;
    HashMap<Product, Integer> items = new HashMap<>();

    public double getSubtotal() {
        double subtotal = 0.0;
        for (Product p : items.keySet()) {
            subtotal += p.getPrice() * items.get(p);
        }

        return subtotal;
    }

    @Override
    public double calculateTax() {
        double discounted = discount.apply(getSubtotal());
        return discounted * 0.10;
    }

    public double getTotal() {
        double discounted = discount.apply(getSubtotal());
        double tax = discounted * .10;
        return discounted + tax;
    }

    public void addProduct(Product p, int quantity) {
        if (p.getStock() >= quantity) {
            items.put(p, quantity);
            p.reduceStock(quantity);

        } else {
            System.out.println("Not enough stock for " + p.getName());
        }
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    private OrderStatus status = OrderStatus.PENDING;

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    private ShippingEstimate shipping;

    public Order(String customerAddress) {
        this.shipping = new ShippingEstimate(customerAddress);
        this.status = OrderStatus.PENDING;
    }

    @Override
    public String toString() {
        return shipping.toString()
                + "\nStatus: " + status
                + "\nSubtotal: USD$" + String.format("%.2f", getSubtotal())
                + "\nTax: USD$" + String.format("%.2f", calculateTax())
                + "\nTotal: USD$" + String.format("%.2f", getTotal());
    }

}
