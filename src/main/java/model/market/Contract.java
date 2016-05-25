/**
 * 
 */
package model.market;

import java.util.HashSet;
import java.util.Set;

import model.player.Assistants;
import model.player.Coins;
import model.player.Player;

/**
 * @author Riccardo Pressiani
 *
 */
public class Contract {
	
	private Set<Marketable> sellBag;
	private Set<Marketable> buyBag;
	
	private Player seller;
	
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
	
	/**
	 * @param nCoins
	 */
	public void buyCoins(Integer nCoins){
		if(nCoins<=0) {
			throw new IllegalArgumentException("players should buy nCoins>0"); 
		}
		buyBag.add(new Coins(nCoins));
	}
	
	/**
	 * @param nAssistants
	 */
	public void buyAssistants(Integer nAssistants){
		if(nAssistants>0) {
			throw new IllegalArgumentException("players should buy nAssistants>0"); 
		}
		buyBag.add(new Assistants(nAssistants));
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
