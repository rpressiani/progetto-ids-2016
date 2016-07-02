/**
 * 
 */
package model.market;

import java.util.HashSet;
import java.util.Set;

import model.bonusable.PermissionCard;
import model.player.Assistants;
import model.player.Coins;
import model.player.Player;
import model.politicalDeck.PoliticalContainer;

/**
 * @author Riccardo Pressiani
 *
 */
public class Contract {
	
	private Set<Marketable> sellBag;
	private Set<Marketable> buyBag;
	
	private Player seller;
	
	/**
	 * Constructor
	 * @param seller
	 * @throws NullPointerException if seller is null
	 */
	public Contract(Player seller){
		if(seller==null) {
			throw new NullPointerException("seller cannot be null"); 
		}
		
		this.sellBag = new HashSet<Marketable>();
		this.buyBag = new HashSet<Marketable>();
		
		this.seller = seller;
	
	}
	
	/**
	 * @param nCoins
	 * @throws IllegalArgumentException if nCoins<=0
	 */
	public void sellCoins(Integer nCoins){
		Coins sellingCoins = new Coins(nCoins);
		sellBag.add(sellingCoins);
	}
	
	/**
	 * @param nAssistants
	 * @throws IllegalArgumentException if nAssistants<=0
	 */
	public void sellAssistants(Integer nAssistants){
		Assistants sellingAssistants = new Assistants(nAssistants);
		sellBag.add(sellingAssistants);
	}
	
	/**
	 * @param permissionCard card to be sold
	 * @throws NullPointerException if permissionCard is null
	 */
	public void sellPermissionCard(PermissionCard permissionCard){
		sellBag.add(permissionCard);
	}

	/**
	 * @param structure politicalCards to be sold
	 * @throws NullPointerException is structure is null
	 */
	public void sellPoliticalCards(PoliticalContainer sellingCards) {
		sellBag.add(sellingCards);	
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
	public void buyPoliticalCards(PoliticalContainer buyingCards) {
		buyBag.add(buyingCards);
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
