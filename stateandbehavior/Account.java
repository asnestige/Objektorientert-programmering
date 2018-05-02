package stateandbehavior;
public class Account {
	private double balance, interestRate;
	public Account(){
		this.balance = 0;
		this.interestRate = 0;
	}
	public Account(double balance, double interestRate) {
		this.balance = balance;
		this.interestRate = interestRate; 
	}
	public void deposit(double amount) {
		if (amount >= 0) { 
		balance = balance + amount;
		}
	}
	public double getBalance() {
		return balance;
	}
	public void addInterest() {
		balance = balance + ((balance * interestRate)/100);
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public String toString() {
		return String.format("[Account balance=%s, interestRate=%s]", balance, interestRate);	
	}
	public static void main(String[] args) {
		Account asneskonto = new Account(500,15);
		asneskonto.addInterest();
		asneskonto.deposit(100);
		asneskonto.getBalance();
		asneskonto.setInterestRate(15);
		asneskonto.getInterestRate();
		System.out.println(asneskonto.toString());
	}
}


