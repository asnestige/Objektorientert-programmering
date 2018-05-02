package testing;

import org.junit.Before;

import junit.framework.TestCase;


public class AccountTest extends TestCase{ //Husk "extends TestCase"
	private Account a1;
	private Account a2;
	private Account a3;
	
	@Before
	public void setUp() throws Exception { //Oppretter kontoer for testing 
		a1 = new Account(1000,2);
		a2 = new Account(5000,3); 
		a3 = new Account(2000,1); 
	}
	
	
	public void testaccount() { //Sjekker at getbalance og getinterestrate fungerer 
		assertEquals(1000.0, a1.getBalance());
		assertEquals(2.0, a1.getInterestRate());
	}
	
	
	public void testvalidInterestRate() { //Sjekker at man ikke kan legge til negativ interestrate
		try {
			a2.setInterestRate(-1); 
			fail("Negativt amount");
		}
		catch (IllegalArgumentException e) {
			
		}
	}
	
	
	public void testvalidAmount() { //Sjekker at man ikke kan trekke fra negative tall 
		try { 
			a2.deposit(-1000); 
			fail("Negativt amount");
		}
		catch (IllegalArgumentException e) {	
		}
	}
	
	
	public void testdeposit() { //Sjekker at deposit fungerer 
		a1.deposit(1000); 
		assertEquals(2000.0, a1.getBalance());
	}
	
	
	public void testwithdraw() { //Sjekker at withdraw fungerer 
		a2.withdraw(1000); 
		assertEquals(4000.0, a2.getBalance());
		
		try { 
			a2.withdraw(6000);
			fail("For høy amount");
		}
		catch (IllegalArgumentException e) {	
		}
	}
	public void testinterestRate() { //Sjekker at withdraw fungerer
		a3.setInterestRate(2);  
		a3.addInterest();
		assertEquals(2040.0, a3.getBalance());
	}
}

