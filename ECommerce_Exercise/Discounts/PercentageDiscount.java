package ECommerce_Exercise.Discounts;

public class PercentageDiscount extends Discount {

    private double percentage;

    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double apply(double price) {
        return price - (price * percentage);
    }

}
