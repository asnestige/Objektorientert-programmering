package inheritance;

public class SavingsAccount implements Account{
	protected int balance = 0; 
	protected double interest; 
	
	public SavingsAccount(double interest) {
		this.interest= interest; 
	}
	
	@Override
	public void deposit(double amount) {	
		if(amount < 0) {
			throw new IllegalArgumentException("The amount must be positive");
		}
		balance += amount; 
	}

	@Override
	public void withdraw(double amount) {
		if(amount < 0) {
			throw new IllegalArgumentException("The amount must be positive, and less then balance");
		}
		if (amount > balance) {
			throw new IllegalStateException("You dont have this much money...");
		}
		balance -= amount; 
	}

	public void endYearUpdate() {
		balance += balance*interest;
	}
	
	@Override
	public double getBalance() {
		return balance;
	}
}
