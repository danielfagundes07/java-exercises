package ECommerce_Exercise.Discounts;

public class FixedDiscount extends Discount {
    private final int fixedDiscount = 20;

    @Override
    public double apply(double price) {
        return price - fixedDiscount;
    }

}
