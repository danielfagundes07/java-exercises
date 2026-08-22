package ECommerce_Exercise.Discounts;

public class NoDiscount extends Discount {
    @Override
    public double apply(double price) {
        return price;
    }
}
