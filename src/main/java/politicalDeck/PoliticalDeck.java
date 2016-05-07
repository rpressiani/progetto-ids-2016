package politicalDeck;
import java.awt.Color;
import java.awt.color.*; 
import java.util.Random; 
import java.util.ArrayList; 

public class PoliticalDeck {
	private PoliticalCard[] deck;  
	
	public PoliticalDeck() {
		deck = new PoliticalCard[7]; 
		for(int i=1; i<=7; i++) {
			if(i==1) {
				deck[i] = new PoliticalCard(new Color(0,0,0), 13); 
			}
			if(i==2) {
				deck[i] = new PoliticalCard(new Color(255,255,255), 13); 
			}
			if(i==3) {
				deck[i] = new PoliticalCard(new Color(10, 10, 10), 13);
			}
			if(i==4) {
				deck[i] = new PoliticalCard(new Color(20, 20, 20), 13);
			}
			if(i==5) {
				deck[i] = new PoliticalCard(new Color(30, 30, 30), 13);
			}
			if(i==6) {
				deck[i] = new PoliticalCard(new Color(40, 40, 40), 13);
			}
			if(i==7) {
				deck[i] = new PoliticalCard(new Color(1, 2, 3), 12);
			}
		}
	}
	
	public boolean isEmpty() {
		return deck==null;
	}
	//estrai una carta a caso
	public void pickRandomCard() {
		Random rand = new Random();
		PoliticalCard card = deck[rand.nextInt(7)];
		
	}
}

