package quickstart;

public class Card {
	private int value;
	private int face;
	private boolean specialCard = false; //cards like joker
	private int specialValue; //if multiple special cards
	
	public Card(int value, int face) {
		this.value = value;
		this.face = face;
	}
	
	public Card(int SpecialValue) {
		this.specialCard = true;
		this.specialValue = specialValue;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public int getFace() {
		return this.face;
	}
	
	public boolean isSpecial() {
		return this.specialCard;
	}
	
	public int getSpecial() {
		return this.specialValue;
	}
	
	public String toString() {
		return getValueString(this.value) + " of " + getFace(this.face);
	}
	
	private String getFace(int i) {
		if(i == 0) {
			return "Hearts";
		}
		else if(i == 1) {
			return "Diamonds";
		}
		else if(i == 2) {
			return "Spades";
		}
		else {
			return "Clubs";
		}
	}
	
	private String getValueString(int i) {
		if(i == 0) {
			return "Ace";
		}
		else if(i == 10) {
			return "Jack";
		}
		else if(i == 11) {
			return "Queen";
		}
		else if(i == 12) {
			return "King";
		}
		else {
			return i+1+"";
		}
	}
}
