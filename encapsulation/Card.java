package encapsulation;

public class Card {
	private char suit;
	private int face;
	
	public Card(char suit, int face) {
		setSuit(suit);
		setFace(face);
	}

	public char getSuit() {
		return suit;
	}
	public void setSuit(char suit) {
		if (suit != 'S' && suit != 'H' && suit != 'D' && suit != 'C' ) {
			throw new IllegalArgumentException("Wrong suit");
		}
		this.suit = suit;
	}
	public int getFace() {
		return face;
	}
	public void setFace(int face) {
		if (face > 13 || face < 1) {
			throw new IllegalArgumentException("Wrong face");
		}
		this.face = face;
	}
	public String toString() {
		return "" + suit + face;	
	}
}