package quickstart;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Blackjack {
	
	private ArrayList<ArrayList<Card>> hands;
	private ArrayList<Integer> values;
	private ArrayList<Card> dealer;
	private Deck deck;
	private Scanner r;
	
	public Blackjack(int players) {
		hands = new ArrayList<ArrayList<Card>>();
		dealer = new ArrayList<Card>();
		deck = new Deck();
		values = new ArrayList<Integer>();
		r = new Scanner(System.in);
		
		for(int i = 0; i < players; i++) {
			hands.add(new ArrayList<Card>());
		}
	}
	
	public void startGame() {
		String userInput = "";
		while(true) {
			System.out.println("_ _ _");
			System.out.println("Start new game or exit? start/exit");
			userInput = r.next().toLowerCase();
			if(userInput.equals("start")) {
				gameOn();
			}
			else if(userInput.equals("exit")) {
				break;
			}
			else {
				System.out.println("Invalid command.");
			}
		}
	}
	
	private void gameOn() {
		for(int i = 0; i < 4; i++) {
			deck.createDefaultDeck();
		}
		deck.shuffleDeck();
		
		for(int i = 0; i < hands.size(); i++) {
			hands.get(i).add(deck.draw());
			hands.get(i).add(deck.draw());
		}
		
		for(int i = 0; i < hands.size(); i++) {
			turn(i);
		}
		dealerTurn();
	}
	
	private int calculateValue(ArrayList<Card> c) {
		int value = 0;
		int aces = 0;
		for(int i = 0; i < c.size(); i++) {
			if(c.get(i).getValue() == 0) {
				aces++;
				value = value + 11;
			}
			else if (c.get(i).getValue() == 0 && value > 10){
				value = value + 1;
			}
			else {
				if(c.get(i).getValue() > 9) {
					value = value + 10;
				}
				else {
					value = value + c.get(i).getValue() + 1;
				}
			}
			if(value > 21) {
				if(aces > 0) {
					value = value - 10;
					aces--;
				}
			}
			
		}
		return value;
	}
	
	private void turn(int i) {
		System.out.println("_ _ _");
		System.out.println("Player: " + i);
		String userInput = "";
		while(true) {
			int value = calculateValue(hands.get(i));
			System.out.println(hands.get(i) + ", total value: "+ value);
			if(value == 21) {
				System.out.println("Blackjack!");
				values.add(value);
				break;
			}
			if(value > 21) {
				System.out.println("You went over.");
				values.add(value);
				break;
			}
			System.out.println("Hit or stay?");
			userInput = r.next().toLowerCase();
			if(userInput.equals("hit")) {
				hands.get(i).add(deck.draw());
			}
			if(userInput.equals("stay")) {
				values.add(value);
				break;
			}
		}
	}
	
	private void dealerTurn() {
		System.out.println("_ _ _");
		dealer.add(deck.draw());
		dealer.add(deck.draw());
		int value = calculateValue(dealer);
		System.out.println("Dealer hand: " + dealer + " Value: " + value);
		for(int i = 0; value < 17; i++) {
			dealer.add(deck.draw());
			value = calculateValue(dealer);
			System.out.println(dealer + " Value: " + value);
		}
	}
	
}
