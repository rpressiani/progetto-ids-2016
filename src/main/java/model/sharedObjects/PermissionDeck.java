package model.sharedObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import jaxb.CFGPermissionCard;
import jaxb.CFGPermissionDeck;
import model.bonusItem.BonusItem;
import model.bonusable.PermissionCard;
import model.map.City;
import model.map.Region;
import parser.Parser;

public class PermissionDeck {
	
	private LinkedList<PermissionCard> deck;
	private ArrayList<PermissionCard> visibleCards;
	private final int visibleLenght;

	/**
	 * create PermissionDeck for each region
	 * @param parser can't be null
	 * @param region can't be null
	 */
	public PermissionDeck(Parser parser, Region region){
		this.deck=new LinkedList<PermissionCard>();
		this.visibleCards=new ArrayList<PermissionCard>();
		this.visibleLenght = parser.getCFGRoot().getPermissionDecks().getVisibleCards().intValue();

		List<CFGPermissionDeck> permissionDeckList = parser.getCFGRoot().getPermissionDecks().getPermissionDeck();
		CFGPermissionDeck cfgPermissionDeck = new CFGPermissionDeck();
		Integer index = new Integer(0);
		for (Iterator<CFGPermissionDeck> iterator = permissionDeckList.iterator(); iterator.hasNext();) {
			cfgPermissionDeck = iterator.next();
			index++;
			if (cfgPermissionDeck.getRegion() == region.getName()){
				break;
			}
		}
		
		List<CFGPermissionCard> cfgPermissionCards = cfgPermissionDeck.getPermissionCards().getPermissionCard();
		
		for (Iterator<CFGPermissionCard> iterator = cfgPermissionCards.iterator(); iterator.hasNext();) {
			CFGPermissionCard cfgPermissionCard = iterator.next();
			ArrayList<BonusItem> bonuses = new ArrayList<BonusItem>();
			HashSet<City> cities = new HashSet<City>();
			
			bonuses = parser.getBonusesFromParser(cfgPermissionCard.getBonuses().getBonus());
			
			for (Iterator<String> iteratorCities = cfgPermissionCard.getCities().getCity().iterator(); iteratorCities.hasNext();) {
				String cityName = iteratorCities.next();
				for (Iterator<City> iteratorMatchCity = region.getRegionCities().iterator(); iteratorMatchCity.hasNext();) {
					City cityToAdd = iteratorMatchCity.next();
					if (cityToAdd.getName() == cityName) {
						cities.add(cityToAdd);
						break;
					}
				}
			}
			this.deck.add(new PermissionCard(bonuses, cities));
		}
		
		shuffleDeck(deck);
		
		for(int i=0; i<visibleLenght; i++){
			visibleCards.add(deck.remove());
		}
	}

	/**
	 * shuffle the deck
	 * @param deck can'tt be null
	 */
	public void shuffleDeck(LinkedList<PermissionCard> deck){
		Collections.shuffle(deck);
	}
	
	/**
	 * 
	 * @param deck can'tt be null
	 * @param visibleCards can't be null 
	 * @param index can't be negative
	 * @return the drawed card
	 */
	public PermissionCard drawCard(LinkedList<PermissionCard> deck, ArrayList<PermissionCard> visibleCards, int index){
		PermissionCard drawedCard=visibleCards.remove(index);
		visibleCards.add(index, deck.remove());
		return drawedCard;
	}
	
	/**
	 * substitute visible cards
	 * @param deck can't be null
	 * @param visibleCards can't be null
	 */
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
