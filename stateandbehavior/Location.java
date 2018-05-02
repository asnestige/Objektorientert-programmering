package stateandbehavior;

public class Location {
	private int x = 0;
	private int y = 0;
	
	public void up() {
		y = y - 1; 
	}
	public void down() {
		y = y + 1;
	}
	public void left() {
		x = x - 1;
	}
	public void right() {	
		x = x + 1;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public String toString() {
		return String.format("Location = (%s, %s)", getX(),y);
	} 
	public static void main(String[] args) {
	    Location location = new Location();
	    location.up();
	    location.up();
	    location.left();
	    System.out.println(location);
	} 
}
