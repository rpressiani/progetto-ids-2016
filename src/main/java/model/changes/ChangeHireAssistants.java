package model.changes;

import dto.changes.DTOChangeHireAssistants;
import model.player.Assistants;
import model.player.Coins;
import view.VisitorChanges;

public class ChangeHireAssistants implements Change {

	private Assistants assistants;
	private Coins coins;
	
	public ChangeHireAssistants(Assistants assistants, Coins coins) {
		if(assistants==null) {
			throw new NullPointerException("assistants cannot be null"); 
		}
		if(coins==null) {
			throw new NullPointerException("coins cannot be null"); 
		}
		this.assistants=assistants;
		this.coins=coins;
	}
	
	@Override
	public DTOChangeHireAssistants accept(VisitorChanges v) {
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
