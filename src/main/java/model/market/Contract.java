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
import model.politicalDeck.PoliticalMarketContainer;
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
	
	public void sellPermissionCard(PermissionCard permissionCard){
		if (permissionCard.verifyAdd(seller) == true) {
			sellBag.add(permissionCard);
		}
	}

	public void sellPoliticalCards(ArrayList<Integer> structure){
		PoliticalMarketContainer sellingCards = new PoliticalMarketContainer(this.parser, structure);
		if (sellingCards.verifyAdd(seller) == true) {
			sellBag.add(sellingCards);
		}
	}
	
	/**
	 * @param nCoins
	 */
	public void buyCoins(Integer nCoins){
		if(nCoins<0) {
			throw new IllegalArgumentException("players should buy nCoins>=0"); 
		}
		buyBag.add(new Coins(nCoins));
	}
	
	/**
	 * @param nAssistants
	 */
	public void buyAssistants(Integer nAssistants){
		if(nAssistants<0) {
			throw new IllegalArgumentException("players should buy nAssistants>0"); 
		}
		buyBag.add(new Assistants(nAssistants));
	}
	
	public void buyPermissionCard(PermissionCard permissionCard){
		buyBag.add(permissionCard);
	}
	
	public void buyPoliticalCards(ArrayList<Integer> structure){
		buyBag.add(new PoliticalMarketContainer(this.parser, structure));
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
