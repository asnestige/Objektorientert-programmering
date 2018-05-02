package inheritance;

public class CreditAccount extends AbstractAccount{
	private double creditLine;
	
	public CreditAccount(double creditLine) {
		this.creditLine = creditLine; 
	}
	
	@Override
	public void internalWithdraw(double amount) {
		if (balance < amount) {
			if ((Math.abs(balance - amount)) > creditLine)
				throw new IllegalStateException("You can not take out this much money...");
		}
		balance -= amount; 	
	}
	
	public void setCreditLine(double creditLine) {
		if (creditLine < 0)
			throw new IllegalArgumentException("Creditline can not be under zero");
		if ((balance < 0) && (creditLine < Math.abs(balance)))
			throw new IllegalStateException("Creditline can not be under zero");
		
		this.creditLine = creditLine; 
	}
	
	public double getCreditLine() {
		return creditLine; 
	}
}
