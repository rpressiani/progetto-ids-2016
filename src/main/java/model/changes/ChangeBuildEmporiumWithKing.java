package model.changes;

import dto.changes.DTOChangeBuildEmporiumWithKing;
import model.map.City;
import model.player.Assistants;
import model.player.Coins;
import model.player.Player;
import view.VisitorChanges;

public class ChangeBuildEmporiumWithKing implements Change {

	private Coins coins;
	private Assistants assistants;
	private City city;
	
	public ChangeBuildEmporiumWithKing(Coins coins, Assistants assistants, City city){
		this.coins=coins;
		this.assistants=assistants;
		this.city=city;
	}
	
	@Override
	public DTOChangeBuildEmporiumWithKing accept(VisitorChanges v, Player player) {
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
