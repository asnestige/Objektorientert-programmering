package encapsulation;

import java.util.*;

public class CardDeck {
	//private int n; 
	private List<Card> deck = new ArrayList<Card>();
	
	public CardDeck(int n) {
		for (int i = 1; i <= n; i++) {
			deck.add(new Card('S',i));
		}
		for (int i = 1; i <= n; i++) {
			char hart = 'H';
			Card card = new Card(hart,i);
			deck.add(card);
		}
		for (int i = 1; i <= n; i++) {
			char dimond = 'D';
			Card card = new Card(dimond,i);
			deck.add(card);
		}
		for (int i = 1; i <= n; i++) {
			char clubs = 'C';
			Card card = new Card(clubs,i);
			deck.add(card);
		}
	}
	public int getCardCount() {
		return deck.size();
	}
	
	public Card getCard(int n) {
		if (n < 0 || n >= getCardCount()) {
			throw new IllegalArgumentException("n is to high or to low");
		}
		return deck.get(n);
	}
	
	public String toString() {
		return deck.toString();
	}
	
	public void shufflePerfectly() {
		int half = deck.size()/2;
		for (int i = 0; i < half; i++) {
			Card card = deck.remove(half + i);
			deck.add(i * 2 + 1, card);
		}
	}
	public static void main(String[] args) {
		CardDeck card = new CardDeck (2);
		System.out.println(card);
		card.shufflePerfectly();
		System.out.println(card);
		
	}
}