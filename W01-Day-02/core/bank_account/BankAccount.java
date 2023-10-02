import java.util.Random;

public class BankAccount {
    // Class attributes
    private static int numAccounts = 0;
    private static double totalBalance = 0;

    private double checkingBalance;
    private double savingsBalance;
    private String accountNumber;

    // Constructor
    public BankAccount(double initialCheckingBalance, double initialSavingsBalance) {
        this.checkingBalance = initialCheckingBalance;
        this.savingsBalance = initialSavingsBalance;
        this.accountNumber = generateAccountNumber();

        // Increment the number of accounts and update total balance
        numAccounts++;
        totalBalance += initialCheckingBalance + initialSavingsBalance;
    }

    // Private method to generate a random 10-digit account number
    private String generateAccountNumber() {
        Random rand = new Random();
        StringBuilder accountNumber = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            accountNumber.append(rand.nextInt(10));
        }
        return accountNumber.toString();
    }

    // Getter method for checking balance
    public double getCheckingBalance() {
        return checkingBalance;
    }

    // Getter method for savings balance
    public double getSavingsBalance() {
        return savingsBalance;
    }

    // Method to deposit money into either checking or savings
    public void deposit(double amount, String accountType) {
        if ("checking".equalsIgnoreCase(accountType)) {
            checkingBalance += amount;
        } else if ("savings".equalsIgnoreCase(accountType)) {
            savingsBalance += amount;
        } else {
            System.out.println("Invalid account type specified. Use 'checking' or 'savings'.");
        }

        totalBalance += amount;
    }

    // Method to withdraw money from one balance
    public void withdraw(double amount, String accountType) {
        if ("checking".equalsIgnoreCase(accountType)) {
            if (checkingBalance >= amount) {
                checkingBalance -= amount;
                totalBalance -= amount;
            } else {
                System.out.println("Insufficient funds in checking account.");
            }
        } else if ("savings".equalsIgnoreCase(accountType)) {
            if (savingsBalance >= amount) {
                savingsBalance -= amount;
                totalBalance -= amount;
            } else {
                System.out.println("Insufficient funds in savings account.");
            }
        } else {
            System.out.println("Invalid account type specified. Use 'checking' or 'savings'.");
        }
    }

    // Method to see the total money from checking and savings
    public double getTotalBalance() {
        return totalBalance;
    }
}
