package inheritance;

public abstract class AbstractAccount {
	protected double balance; 
	
	public abstract void internalWithdraw(double amount); //Minker kontobalansen
	
	public void withdraw(double amount) {
		if (amount < 0) 
			throw new IllegalArgumentException("The amount must be positive");
		internalWithdraw(amount); 
	}
	
	public void deposit(double amount) {
		if (amount < 0) 
			throw new IllegalArgumentException("The amount must be positive");
		balance += amount; 
	}
	
	public double getBalance() {
		return balance; 
	}
}