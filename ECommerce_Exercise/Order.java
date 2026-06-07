package exercises.ECommerce_Exercise;

import java.util.HashMap;

import exercises.ECommerce_Exercise.Discounts.Discount;

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

    @Override
    public String toString() {
        return "Subtotal: USD$" + getSubtotal() +
                "\nTax: USD$" + calculateTax() +
                "\nTotal: USD$" + getTotal();
    }

}
