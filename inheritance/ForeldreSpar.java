package inheritance;

import inheritance.SavingsAccount; 

public class ForeldreSpar extends SavingsAccount{
	private int withdrawals;
	private int totalWithdrawals;
	
	public ForeldreSpar(double interest, int withdrawals) {
		super(interest);
		this.interest = interest; 
		if (withdrawals < 0) {
			throw new IllegalArgumentException("Must be positive");
		}
		this.totalWithdrawals = withdrawals; 
		this.withdrawals = withdrawals; 
	}
	
	public int getRemainingWithdrawals() {
		return withdrawals; 
	}
	
	@Override
	public void endYearUpdate() {
		balance += balance*interest;
		withdrawals = totalWithdrawals; 
	}
	
	@Override
	public void withdraw(double amount) {
		if(amount < 0) {
			throw new IllegalArgumentException("The amount must be positive, and less then balance");
		}
		if (amount > balance) {
			throw new IllegalStateException("You dont have this much money...");
		}
		if (withdrawals == 0) {
			throw new IllegalStateException("You can not withdrawal more money");
		}
		balance -= amount; 
		withdrawals -= 1; 
	}
}
