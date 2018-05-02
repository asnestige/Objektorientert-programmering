package inheritance;

public class BSU extends SavingsAccount{
	private double roof; //Maks beløp som kan settes inn på konto hvert år 
	private double taxDeduction;
	private double yearBalance; 
	
	public BSU(double interest, double roof){
		super(interest);
		this.interest = interest; 
		this.roof = roof; 
	}
	
	public void setTaxDeduction() {
		taxDeduction = yearBalance*0.2;
	}
	
	public double getTaxDeduction() {
		setTaxDeduction();
		return taxDeduction; 
	}
	
	@Override
	public void endYearUpdate() {
		balance += balance*interest;
		yearBalance = 0;
	}
	
	@Override
	public void deposit(double amount) {
		if(amount < 0) {
			throw new IllegalArgumentException("The amount must be positive");
		}
		if((yearBalance + amount) > roof) {
			throw new IllegalStateException("You can only deposit 25000 per year");
		}
		yearBalance += amount; 
		balance += amount; 
	}

	@Override
	public void withdraw(double amount) {
		if(amount < 0) {
			throw new IllegalArgumentException("The amount must be positive, and less then balance");
		}
		if (amount > yearBalance) {
			throw new IllegalStateException("You dont have this much money...");
		}
		yearBalance -= amount;
		balance -= amount;
	}
}
