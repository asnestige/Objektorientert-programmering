package encapsulation;

public class Account {
	private double balance, interestRate; 
	public Account(double balance, double interestRate) {
		if (balance > 0 && interestRate > 0) {
			this.balance = balance;
			this.interestRate = interestRate;
		}
		else {
			throw new IllegalArgumentException("Can not be negative");
		}
	}
	public double getBalance() {
		return balance;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		if (interestRate > 0) {
			this.interestRate = interestRate;
		}
		else {
			throw new IllegalArgumentException("InterestRate can not be negative");
		}
	}
	public void deposit(double amount) {
		if (amount > 0) {
			this.balance = balance + amount;
		}
		else {
			throw new IllegalArgumentException("Amount can not be negative");
		}
	}
	void withdraw(double amount) {
		double a = balance - amount;
		if (amount > 0 && a > 0) {
			this.balance = balance - amount;
		}
		else {
			throw new IllegalArgumentException("There is not enough money on the account");
		}
	}
	void addInterest() {
		balance = balance + ((balance * interestRate)/100);
	}
}
