/**
 * 
 */
package model.market;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import model.bonusable.PermissionCard;
import model.player.Assistants;
import model.player.Coins;
import model.player.Player;
import model.politicalDeck.PoliticalContainer;
import parser.Parser;

/**
 * @author Riccardo Pressiani
 *
 */
public class Contract {
	
	private Set<Marketable> sellBag;
	private Set<Marketable> buyBag;
	
	private Player seller;
	
	private Parser parser;
	
	public Contract(Player seller){
		if(seller==null) {
			throw new NullPointerException("seller cannot be null"); 
		}
		this.sellBag = new HashSet<Marketable>();
		this.buyBag = new HashSet<Marketable>();
		
		this.seller = seller;
		
		this.parser = new Parser();
	}
	
	/**
	 * @param nCoins
	 * @throws IllegalArgumentException if nCoins<=0
	 */
	public void sellCoins(Integer nCoins){
		if(nCoins<=0) {
			throw new IllegalArgumentException("players should be selling nCoins>0"); 
		}
		Coins sellingCoins = new Coins(nCoins);
		if (sellingCoins.verifyAdd(seller) == true) {
			sellBag.add(sellingCoins);
		}
		else System.out.println(this.seller + "doesn't have enough coins!");
	}
	
	/**
	 * @param nAssistants
	 * @throws IllegalArgumentException if nAssistants<=0
	 */
	public void sellAssistants(Integer nAssistants){
		if(nAssistants<=0) {
			throw new IllegalArgumentException("players should be selling nAssistants>0"); 
		}
		Assistants sellingAssistants = new Assistants(nAssistants);
		if (sellingAssistants.verifyAdd(seller) == true) {
			sellBag.add(sellingAssistants);
		}
		else System.out.println(this.seller + "doesn't have enough coins!");
	}
	
	/**
	 * @param permissionCard card to be sold
	 * @throws NullPointerException if permissionCard is null
	 */
	public void sellPermissionCard(PermissionCard permissionCard){
		if(permissionCard==null) {
			throw new NullPointerException("permissionCard should not be null"); 
		}
		if (permissionCard.verifyAdd(seller) == true) {
			sellBag.add(permissionCard);
		}
	}

	/**
	 * @param structure politicalCards to be sold
	 * @throws NullPointerException is structure is null
	 */
	public void sellPoliticalCards(ArrayList<Integer> structure) {
		if(structure==null) {
			throw new NullPointerException("structure should not be null"); 
		}
		PoliticalContainer sellingCards = new PoliticalContainer(this.parser, structure);
		if (sellingCards.verifyAdd(seller) == true) {
			sellBag.add(sellingCards);
		}
	}
	
	/**
	 * @param nCoins
	 * @throws IllegalArgumentException if nCoins<=0
	 */
	public void buyCoins(Integer nCoins){
		if(nCoins<0) {
			throw new IllegalArgumentException("players should buy nCoins>=0"); 
		}
		buyBag.add(new Coins(nCoins));
	}
	
	/**
	 * @param nAssistants
	 * @throws IllegalArgumentException is nAssistants<0
	 */
	public void buyAssistants(Integer nAssistants){
		if(nAssistants<0) {
			throw new IllegalArgumentException("players should buy nAssistants>=0"); 
		}
		buyBag.add(new Assistants(nAssistants));
	}
	
	/**
	 * @param permissionCard to be sold
	 * @throws NullPointerException is permissionCard is null
	 */
	public void buyPermissionCard(PermissionCard permissionCard) {
		if(permissionCard==null) {
			throw new NullPointerException("permissionCard should not be null"); 
		}
		buyBag.add(permissionCard);
	}
	
	/**
	 * @param structure political cards to be sold
	 * @throws NullPointerException if structure is null
	 */
	public void buyPoliticalCards(ArrayList<Integer> structure) {
		if(structure==null) {
			throw new NullPointerException("structure should not be null");
		}
		buyBag.add(new PoliticalContainer(this.parser, structure));
	}

	/**
	 * @return the sellBag
	 */
	public Set<Marketable> getSellBag() {
		return sellBag;
	}

	/**
	 * @return the buyBag
	 */
	public Set<Marketable> getBuyBag() {
		return buyBag;
	}

	/**
	 * @return the seller
	 */
	public Player getSeller() {
		return seller;
	}
	

}
