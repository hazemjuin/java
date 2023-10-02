import java.util.ArrayList;

class Item {
    String name;
    double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Order {
    String name;
    double total;
    boolean ready;
    ArrayList<Item> itemList = new ArrayList<>();

    public Order(String name) {
        this.name = name;
        this.total = 0.0;
        this.ready = false;
    }

    public void addItem(Item item) {
        itemList.add(item);
        total += item.price;
    }

    public void markReady() {
        ready = true;
    }
}

public class TestOrders {
    public static void main(String[] args) {

        // Create 4 item variables
        Item item1 = new Item("mocha", 4.5);
        Item item2 = new Item("latte", 3.8);
        Item item3 = new Item("drip coffee", 2.5);
        Item item4 = new Item("cappuccino", 5.0);

        // Create 4 order variables
        Order order1 = new Order("Cindhuri");
        Order order2 = new Order("Jimmy");
        Order order3 = new Order("Noah");
        Order order4 = new Order("Sam");

        // Print order1
        System.out.println("Order 1:");
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %.2f\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);

        // Add item1 to order2 and increment total
        order2.addItem(item1);

        // order3 ordered a cappuccino
        order3.addItem(item4);

        // order4 added a latte
        order4.addItem(item2);

        // Cindhuri's order is now ready
        order1.markReady();

        // Sam ordered 2 lattes
        order4.addItem(item2);
        order4.addItem(item2);

        // Jimmy's order is now ready
        order2.markReady();

        // Print updated order information
        System.out.println("\nUpdated Order 1:");
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %.2f\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);

        System.out.println("\nUpdated Order 2:");
        System.out.printf("Name: %s\n", order2.name);
        System.out.printf("Total: %.2f\n", order2.total);
        System.out.printf("Ready: %s\n", order2.ready);

        System.out.println("\nUpdated Order 3:");
        System.out.printf("Name: %s\n", order3.name);
        System.out.printf("Total: %.2f\n", order3.total);
        System.out.printf("Ready: %s\n", order3.ready);

        System.out.println("\nUpdated Order 4:");
        System.out.printf("Name: %s\n", order4.name);
        System.out.printf("Total: %.2f\n", order4.total);
        System.out.printf("Ready: %s\n", order4.ready);
    }
}
