package stateandbehavior;

public class UpOrDownCounter {
	private int end, counter;
	
	
	public UpOrDownCounter(int start, int end) throws IllegalArgumentException {
		if (start == end) {
			throw new IllegalArgumentException("Start and end value must be different.");
		}
		else {
			this.counter = start;
			this.end = end;
		}
	}
	public boolean count() {
		if (counter < end) { //teller oppover
			counter ++;
		}
		else if (counter > end) { //teller nedover
			counter --;
		}
		if (counter == end){
			return false;
		}
		else {
			return true;
		}
	}	
	public int getCounter() {
		return counter;
	}
}
