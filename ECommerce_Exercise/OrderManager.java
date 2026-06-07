
package exercises.ECommerce_Exercise;

import java.util.ArrayList;

public class OrderManager {
    ArrayList<Order> orders = new ArrayList<>();

    public void addOrder(Order o) {
        orders.add(o);
    }

    public double getTotalRevenue() {
        double revenue = 0;
        for (Order o : orders) {
            revenue += o.getTotal();
        }
        return revenue;
    }

    public Order getMostExpensiveOrder() {
        Order mostExpensive = orders.get(0);
        for (Order o : orders) {
            if (o.getTotal() > mostExpensive.getTotal()) {
                mostExpensive = o;
            }
        }
        return mostExpensive;
    }

    public void listAllOrders() {
        for (Order o : orders) {
            System.out.print(o.items.keySet() + ", ");
        }
    }
}
