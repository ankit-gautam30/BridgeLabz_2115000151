import java.util.*;

public class BankingSystem {
    private Map<String, Double> accounts = new HashMap<>();
    private TreeMap<Double, String> sortedAccounts = new TreeMap<>();
    private Queue<String> withdrawalQueue = new LinkedList<>();
    
    public void addAccount(String accountNumber, double balance) {
        accounts.put(accountNumber, balance);
        sortedAccounts.put(balance, accountNumber);
    }
    
    public void deposit(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double newBalance = accounts.get(accountNumber) + amount;
            sortedAccounts.remove(accounts.get(accountNumber));
            accounts.put(accountNumber, newBalance);
            sortedAccounts.put(newBalance, accountNumber);
        } else {
            System.out.println("Account not found!");
        }
    }
    
    public void requestWithdrawal(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
        } else {
            System.out.println("Account not found!");
        }
    }
    
    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            String accountNumber = withdrawalQueue.poll();
            System.out.println("Processing withdrawal for account: " + accountNumber);
        }
    }
    
    public Map<String, Double> getAccounts() {
        return accounts;
    }
    
    public Map<Double, String> getSortedAccounts() {
        return sortedAccounts;
    }
    
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        bank.addAccount("12345", 1000.0);
        bank.addAccount("67890", 1500.0);
        bank.addAccount("54321", 500.0);
        
        bank.deposit("12345", 200.0);
        bank.requestWithdrawal("67890");
        bank.requestWithdrawal("54321");
        
        System.out.println("Accounts: " + bank.getAccounts());
        System.out.println("Sorted Accounts by Balance: " + bank.getSortedAccounts());
        
        bank.processWithdrawals();
    }
}
