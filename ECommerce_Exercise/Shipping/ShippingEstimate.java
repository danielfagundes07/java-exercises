/*
Adress = Recipient's name, Street adress, City, State, zip code
*/

package ECommerce_Exercise.Shipping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ShippingEstimate {

    private static final String WAREHOUSE_ADDRESS = "New York City, USA";
    private String customerAddress;
    private LocalDateTime orderTime;
    private LocalDateTime estimatedTime;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ShippingEstimate(String customerAddress) {
        this.customerAddress = customerAddress;
        this.orderTime = LocalDateTime.now();
        this.estimatedTime = orderTime.plusDays(3);
    }

    public String getWarehouseAdress() {
        return WAREHOUSE_ADDRESS;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public LocalDateTime getEstimatedTime() {
        return estimatedTime;
    }

    @Override
    public String toString() {
        return "Warehouse: " + getWarehouseAdress()
                + "\n Customer address: " + getCustomerAddress()
                + "\n Order time: " + orderTime.format(formatter)
                + "\n Estimated time: " + estimatedTime.format(formatter);
    }
}
