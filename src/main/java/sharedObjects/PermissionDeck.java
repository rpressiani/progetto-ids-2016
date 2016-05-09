package sharedObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.print.attribute.HashAttributeSet;

import bonusItem.BonusAssistants;
import bonusItem.BonusCoins;
import bonusItem.BonusItem;
import bonusItem.BonusNobility;
import bonusItem.BonusScore;
import bonusable.PermissionCard;
import jaxb.CFGBonus;
import jaxb.CFGBonuses;
import jaxb.CFGPermissionCard;
import jaxb.CFGPermissionCards;
import jaxb.CFGPermissionDeck;
import jaxb.CFGPermissionDecks;
import map.City;
import map.Map;
import parser.Parser;

public class PermissionDeck {
	
	private LinkedList<PermissionCard> deck;
	private ArrayList<PermissionCard> visibleCards;
	private final int visibleLenght;

	public PermissionDeck(Parser parser, String region, Map map){
		this.deck=new LinkedList<PermissionCard>();
		this.visibleCards=new ArrayList<PermissionCard>();
		this.visibleLenght=2; //read by parser

		List<CFGPermissionDeck> permissionDeckList = parser.getCFGRoot().getPermissionDecks().getPermissionDeck();
		CFGPermissionDeck cfgPermissionDeck = new CFGPermissionDeck();
		Integer index = new Integer(0);
		for (Iterator<CFGPermissionDeck> iterator = permissionDeckList.iterator(); iterator.hasNext();) {
			cfgPermissionDeck = iterator.next();
			index++;
			if (cfgPermissionDeck.getRegion() == region){
				break;
			}
		}
		
		List<CFGPermissionCard> cfgPermissionCards = cfgPermissionDeck.getPermissionCards().get(index).getPermissionCard();
		for (Iterator<CFGPermissionCard> iterator = cfgPermissionCards.iterator(); iterator.hasNext();) {
			CFGPermissionCard cfgPermissionCard = iterator.next();
			ArrayList<BonusItem> bonuses = new ArrayList<BonusItem>();
			HashSet<City> cities = new HashSet<City>();
			
			for (Iterator<CFGBonus> iteratorBonuses = cfgPermissionCard.getBonuses().getBonus().iterator(); iteratorBonuses.hasNext();) {
				CFGBonus bonus = iteratorBonuses.next();
				BonusItem bonusItem;
				switch (bonus.getBonusItem()) {
				case "coins":
					bonusItem = new BonusCoins(bonus.getQuantity().intValue());
					bonuses.add(bonusItem);
					break;
				case "assistants":
					bonusItem = new BonusAssistants(bonus.getQuantity().intValue());
					bonuses.add(bonusItem);
				case "score":
					bonusItem = new BonusScore(bonus.getQuantity().intValue());
					bonuses.add(bonusItem);
				case "nobility":
					bonusItem = new BonusNobility(bonus.getQuantity().intValue());
				case "politicalCard":
//					To be implemented
					break;
				case "additionalAction":
//					To be implemented
					break;
				case "againPermission":
//					To be implemented
					break;
				case "freePermission":
//					To be implemented
					break;
				case "token":
//					To be implemented
					break;
				default:
					break;
				}
			}
			
			Set<City> allCities = map.allVertexes();
			for (Iterator<String> iteratorCities = cfgPermissionCard.getCities().getCity().iterator(); iteratorCities.hasNext();) {
				String cityName = iteratorCities.next();
				City cityToAdd;
				
			}
			
			this.deck.add(new PermissionCard(bonuses, cities));
		}
//		cfgPermissionDeck.getPermissionCards().get(index)
		
		shuffleDeck(deck);
		
		for(int i=0; i<visibleLenght; i++){
			visibleCards.add(deck.remove());
		}
	}

	public void shuffleDeck(LinkedList<PermissionCard> deck){
		Collections.shuffle(deck);
	}
	
	public PermissionCard drawCard(LinkedList<PermissionCard> deck, ArrayList<PermissionCard> visibleCards, int index){
		PermissionCard drawedCard=visibleCards.remove(index);
		visibleCards.add(index, deck.remove());
		return drawedCard;
	}
	
	public void substituteCards(LinkedList<PermissionCard> deck, ArrayList<PermissionCard> visibleCards){
		for(int i=0, temp=visibleLenght; i<temp; temp--){
			deck.add(visibleCards.remove(i));	//better with iterator?
		}
	}
	
	/**
	 * @return the deck
	 */
	public LinkedList<PermissionCard> getDeck() {
		return deck;
	}
	
	/**
	 * @return the visibleCards
	 */
	public ArrayList<PermissionCard> getVisibleCards() {
		return visibleCards;
	}
	
}
