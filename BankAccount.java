class BankAccount {
    private static String bankName = "ABC Bank";
    private static int totalAccounts = 0;
    private final int accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountHolderName, int accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        totalAccounts++;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public void displayAccountDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: $" + balance);
        }
    }

    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("John Doe", 1001, 5000.00);
        BankAccount acc2 = new BankAccount("Jane Smith", 1002, 7500.50);

        acc1.displayAccountDetails();
        acc2.displayAccountDetails();

        System.out.println("Total Accounts: " + getTotalAccounts());
    }
}
