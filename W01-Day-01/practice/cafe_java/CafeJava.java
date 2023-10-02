public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffeePrice = 2.0;
        double lattePrice = 4.0;
        double cappuccinoPrice = 4.5;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Noah";
        String customer3 = "Sam";
        String customer4 = "Jimmy";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = false;
        boolean isReadyOrder3 = true;  // Sam's order is ready
        boolean isReadyOrder4 = true;  // Jimmy's order is ready
    
        // Simulate Customer Interactions
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
        if (isReadyOrder1) {
            System.out.println(customer1 + readyMessage);
        } else {
            System.out.println(customer1 + pendingMessage);
        }
        
        System.out.println(generalGreeting + customer2); // Displays "Welcome to Cafe Java, Noah"
        if (isReadyOrder2) {
            System.out.println(customer2 + readyMessage);
            System.out.println(displayTotalMessage + cappuccinoPrice);
        } else {
            System.out.println(customer2 + pendingMessage);
        }
        
        System.out.println(generalGreeting + customer3); // Displays "Welcome to Cafe Java, Sam"
        double latteTotal = 2 * lattePrice;
        System.out.println(displayTotalMessage + latteTotal);
        if (isReadyOrder3) {
            System.out.println(customer3 + readyMessage);
        } else {
            System.out.println(customer3 + pendingMessage);
        }
        
        System.out.println(generalGreeting + customer4); // Displays "Welcome to Cafe Java, Jimmy"
        double coffeePrice = 3.5;  // Correct price for coffee
        double lattePriceUpdated = 4.0;  // Correct price for latte
        double totalDifference = lattePriceUpdated - coffeePrice;
        System.out.println(displayTotalMessage + totalDifference);
        
        // Testing with changed prices and statuses
        // Change the values of isReadyOrder2, isReadyOrder4, and prices to test logic with different scenarios.
    }
}
