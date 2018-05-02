package inheritance;

public class DebitAccount extends AbstractAccount{
	@Override
	public void internalWithdraw(double amount) {
		if (amount > balance)
			throw new IllegalStateException("You can not take out this much money...");
		balance -= amount; 	
	}
}
