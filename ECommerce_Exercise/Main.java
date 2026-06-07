
package exercises.ECommerce_Exercise;

import java.util.InputMismatchException;
import java.util.Scanner;

import exercises.ECommerce_Exercise.Discounts.FixedDiscount;
import exercises.ECommerce_Exercise.Discounts.NoDiscount;
import exercises.ECommerce_Exercise.Discounts.PercentageDiscount;

public class Main {
    public static void main(String[] args) {
        boolean exit = false;
        Order currentOrder = null;
        OrderManager manager = new OrderManager();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("\nWELCOME TO E-COMMERCE\n");
            while (!exit) {
                System.out.println("\n*************************\n");

                String menu = "     1. Create new order\n"
                        + "     2. Add product to order\n"
                        + "     3. Apply discount\n"
                        + "     4. Finalize order\n"
                        + "     5. View all orders\n"
                        + "     6. View total revenue\n"
                        + "     7. Exit\n"
                        + "     Type your choice: ";

                System.out.print(menu);

                int option = scanner.nextInt();
                scanner.nextLine();

                if (option == 7) {
                    System.out.println("Exiting Program...");
                    exit = true;
                } else if (option < 1 || option > 7) {
                    System.out.println("Please type a valid option.");
                    continue;
                }

                switch (option) {
                    case 1:
                        currentOrder = new Order();
                        System.out.println("New Order Created successfully!");
                        break;
                    case 2:
                        if (currentOrder == null) {
                            System.out.println("Create an order first!");
                            break;
                        }
                        System.out.println("Please type the product's name, price and stock:");
                        String pName = scanner.nextLine();
                        Double pPrice = scanner.nextDouble();
                        int pStock = scanner.nextInt();
                        Product product = new Product(pName, pPrice, pStock);
                        System.out.println("How many of " + pName + " would you want?");
                        int quantity = scanner.nextInt();
                        scanner.nextLine();
                        currentOrder.addProduct(product, quantity);
                        System.out.println("Product Added sucessfully!");
                        break;
                    case 3:
                        if (currentOrder == null) {
                            System.out.println("Create an order first!");
                            break;
                        }
                        System.out.println("Choose discount:");
                        System.out.println("1. Percentage (10%)");
                        System.out.println("2. Fixed (USD$20 off)");
                        System.out.println("3. No Discount");
                        int discountChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (discountChoice) {
                            case 1:
                                currentOrder.setDiscount(new PercentageDiscount(0.10));
                                break;
                            case 2:
                                currentOrder.setDiscount(new FixedDiscount());
                                break;
                            case 3:
                                currentOrder.setDiscount(new NoDiscount());
                                break;
                        }
                        System.out.println("Discount Applied!");
                        break;
                    case 4:
                        if (currentOrder == null) {
                            System.out.println("Create an order first!");
                            break;
                        }
                        if (currentOrder.getDiscount() == null) {
                            currentOrder.setDiscount(new NoDiscount());
                        }
                        manager.addOrder(currentOrder);
                        System.out.println("Order finalized!");
                        System.out.println(currentOrder);
                        currentOrder = null;
                        break;
                    case 5:
                        manager.listAllOrders();
                        break;
                    case 6:
                        System.out.println("Total Revenue USD$" + manager.getTotalRevenue());
                        break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Please type a number between 1 - 7");

        }

    }
}