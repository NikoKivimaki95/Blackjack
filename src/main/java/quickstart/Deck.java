package quickstart;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	private ArrayList<Card> cards;
	
	public Deck() {
		cards = new ArrayList<Card>();
	}
	
	public ArrayList<Card> getDeck(){
		return cards;
	}
	
	public Card topCard() {
		return cards.get(0);
	}
	
	public Card draw() {
		return cards.remove(0);
	}
	
	public void createDefaultDeck() {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 13; j++) {
				cards.add(new Card(j, i));
			}
		}
	}
	
	public void shuffleDeck() {
		Collections.shuffle(cards);
	}
	
}
