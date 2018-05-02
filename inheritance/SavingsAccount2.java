package inheritance;

public class SavingsAccount2 extends AbstractAccount{
	private int withdrawals; 
	private double fee; 
	
	public SavingsAccount2 (int withdrawals, double fee) {
		this.withdrawals = withdrawals;
		this.fee = fee; 
	}
	
	@Override
	public void internalWithdraw(double amount) {
		if (amount > balance)
			throw new IllegalStateException("You can not take out this much money...");
		if (withdrawals <= 0) {
			if ((amount+fee) > balance)
				throw new IllegalStateException("You can not take out this much money...");
			balance -= fee;
		}
		balance -= amount; 
		withdrawals --; 
	}
	
	public static void main(String[] args) {
		SavingsAccount2 test = new SavingsAccount2(1, 500);
		test.deposit(5000);
		test.withdraw(4930);
	}
}
