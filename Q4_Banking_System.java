abstract class BankAccount {
	private String accountNumber;
	private String holderName;
	private double balance;

	public BankAccount(String accountNumber, String holderName, double balance) {
		this.accountNumber = accountNumber;
		this.holderName = holderName;
		this.balance = balance;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public String getHolderName() {
		return holderName;
	}
	public double getBalance() {
		return balance;
	}
	public void deposit(double amount) {
        	if (amount > 0) {
            		balance += amount;
        	}
    	}

    	public void withdraw(double amount) {
        	if (amount > 0 && amount <= balance) {
            	balance -= amount;
        	}
    	}

    	public abstract double calculateInterest();
}
interface Loanable {
    	boolean applyForLoan(double amount);
	double calculateLoanEligibility();
}
class SavingsAccount extends BankAccount {
    	private double interestRate;

    	public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        	super(accountNumber, holderName, balance);
        	this.interestRate = interestRate;
    	}

    	@Override
    	public double calculateInterest() {
        	return getBalance() * interestRate / 100;
    	}
}
class CurrentAccount extends BankAccount implements Loanable {
      private double overdraftLimit;

      public CurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
          super(accountNumber, holderName, balance);
          this.overdraftLimit = overdraftLimit;
      }

      @Override
      public double calculateInterest() {
          return 0; 
      }

      @Override
      public boolean applyForLoan(double amount) {
          return amount <= calculateLoanEligibility();
      }

      @Override
      public double calculateLoanEligibility() {
          return getBalance() + overdraftLimit;
      }
}

public class Q4_Banking_System {
      public static void main(String[] args) {
          BankAccount[] accounts = new BankAccount[2];

          accounts[0] = new SavingsAccount("SA101", "Amit", 5000, 4);
          accounts[1] = new CurrentAccount("CA202", "Prince", 3000, 2000);

          for (BankAccount account : accounts) {
              System.out.println("Account Holder: " + account.getHolderName() + ", Balance: " + account.getBalance() + ", Interest: " + account.calculateInterest());
              if (account instanceof Loanable) {
                  System.out.println("Loan Eligibility: " + ((Loanable) account).calculateLoanEligibility());
              }
              System.out.println("---------------------------");
          }
      }
}
