import java.util.ArrayList;
import java.util.List;

// Bank class
class Bank {
    private String name;
    private List<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        if (!customers.contains(customer)) {
            customers.add(customer);
        }
    }

    public String getName() {
        return name;
    }
}

// Bank Account class
class BankAccount {
    private String accountNumber;
    private double balance;
    private Bank bank;

    public BankAccount(String accountNumber, double balance, Bank bank) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.bank = bank;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{Number='" + accountNumber + "', Balance='" + balance + "', Bank='" + bank.getName() + "'}";
    }
}

// Customer class
class Customer {
    private String name;
    private List<BankAccount> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void openAccount(Bank bank, String accountNumber, double initialDeposit) {
        BankAccount newAccount = new BankAccount(accountNumber, initialDeposit, bank);
        accounts.add(newAccount);
        bank.addCustomer(this);
    }

    public void viewBalance() {
        System.out.println("Customer: " + name);
        for (BankAccount account : accounts) {
            System.out.println(account);
        }
    }
}

// Main class to demonstrate association
public class BankSystem {
    public static void main(String[] args) {
        // Creating a bank
        Bank bank1 = new Bank("National Bank");

        // Creating customers
        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");

        // Customers opening accounts in the bank
        customer1.openAccount(bank1, "123456", 1000.00);
        customer2.openAccount(bank1, "789012", 2000.00);

        // Viewing balances
        customer1.viewBalance();
        System.out.println();
        customer2.viewBalance();
    }
}
