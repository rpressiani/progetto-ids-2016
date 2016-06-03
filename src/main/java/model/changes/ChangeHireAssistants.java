package model.changes;

import dto.changes.DTOChangeHireAssistants;
import model.player.Assistants;
import model.player.Coins;
import model.player.Player;
import view.VisitorChanges;

public class ChangeHireAssistants implements Change {

	private Assistants assistants;
	private Coins coins;
	
	public ChangeHireAssistants(Assistants assistants, Coins coins) {
		this.assistants=assistants;
		this.coins=coins;
	}
	
	@Override
	public DTOChangeHireAssistants accept(VisitorChanges v, Player player) {
		return v.visit(this);
	}
	
	/**
	 * @return the assistants
	 */
	public Assistants getAssistants() {
		return assistants;
	}

	/**
	 * @return the coins
	 */
	public Coins getCoins() {
		return coins;
	}

}
