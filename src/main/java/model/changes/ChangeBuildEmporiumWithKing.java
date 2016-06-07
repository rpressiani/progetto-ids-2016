package model.changes;

import dto.changes.DTOChangeBuildEmporiumWithKing;
import model.map.City;
import model.player.Assistants;
import model.player.Coins;
import view.VisitorChanges;

public class ChangeBuildEmporiumWithKing implements Change {

	private Coins coins;
	private Assistants assistants;
	private City city;
	
	/**
	 * @param coins
	 * @param assistants
	 * @param city
	 * @throws NullPointerException if coins, assistants or city are null
	 */
	public ChangeBuildEmporiumWithKing(Coins coins, Assistants assistants, City city){
		if(coins==null) {
			throw new NullPointerException("coins cannot be null"); 
		}
		if(assistants==null) {
			throw new NullPointerException("assistants cannot be null"); 
		}
		if(city==null) {
			throw new NullPointerException("city cannot be null"); 
		}
		this.coins=coins;
		this.assistants=assistants;
		this.city=city;
	}
	
	@Override
	public DTOChangeBuildEmporiumWithKing accept(VisitorChanges v) {
		return v.visit(this);
	}

	/**
	 * @return the coins
	 */
	public Coins getCoins() {
		return coins;
	}

	/**
	 * @return the assistants
	 */
	public Assistants getAssistants() {
		return assistants;
	}

	/**
	 * @return the city
	 */
	public City getCity() {
		return city;
	}

}
