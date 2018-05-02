package stateandbehavior;

public class Digit {
	public int base;
	public int num = 0;
	public Digit(int base) {
		this.base = base;	
	} 
	public int getValue() {
		return num;
	}
	public boolean increment() {
		if (num < base - 1) {
			num ++;
			return false;
		}
		else {
			num = 0;
			return true;
		}
	}
	public int getBase() {
		return base;
	} 
	public String toString() {
		String a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String b = String.valueOf(a.charAt(this.num));
		return b;
		
	}
	public static void main(String[] args) {
		Digit test = new Digit(4);
		test.increment();
		System.out.println(test.num);
	}
}