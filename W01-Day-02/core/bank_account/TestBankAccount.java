public class TestBankAccount {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(1000, 2000);
        BankAccount account2 = new BankAccount(1500, 3000);

        System.out.println("Account 1 Checking Balance: " + account1.getCheckingBalance());
        System.out.println("Account 1 Savings Balance: " + account1.getSavingsBalance());

        account1.deposit(500, "checking");
        account1.withdraw(200, "savings");

        // Create instances of BankAccount to access getTotalBalance()
        BankAccount dummyAccount = new BankAccount(0, 0);
        System.out.println("Total Balance for all accounts: " + dummyAccount.getTotalBalance());
    }
}
