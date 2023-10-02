import java.util.ArrayList;

public class CafeUtil {
    // Implement the getStreakGoal method
    public int getStreakGoal() {
        // You can customize the streak goal logic here
        return 10;
    }

    // Implement the printPriceChart method
    public void printPriceChart() {
        System.out.println("Price Chart:");
        System.out.println("Drip Coffee: $1.50");
        System.out.println("Cappuccino: $3.00");
        System.out.println("Latte: $2.50");
        System.out.println("Mocha: $3.50");
    }

    // Implement the getOrderTotal method
    public double getOrderTotal(double[] lineItems) {
        double total = 0.0;
        for (double itemPrice : lineItems) {
            total += itemPrice;
        }
        return total;
    }

    // Implement the displayMenu method
    public void displayMenu(ArrayList<String> menu) {
        System.out.println("Menu:");
        for (String item : menu) {
            System.out.println(item);
        }
    }

    // Implement the addCustomer method
    public void addCustomer(ArrayList<String> customers) {
        // You can add customer logic here
        customers.add("New Customer");
        System.out.println("New customer added!");
    }
}
