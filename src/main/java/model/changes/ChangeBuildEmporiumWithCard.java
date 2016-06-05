package model.changes;

import dto.changes.DTOChangeBuildEmporiumWithCard;
import model.bonusable.PermissionCard;
import model.map.City;
import model.player.Assistants;
import view.VisitorChanges;

public class ChangeBuildEmporiumWithCard implements Change {

	private Assistants assistants;
	private City city;
	private PermissionCard card;
	
	public ChangeBuildEmporiumWithCard(Assistants assistants, City city, PermissionCard card) {
		this.assistants=assistants;
		this.city=city;
		this.card=card;
	}
	
	@Override
	public DTOChangeBuildEmporiumWithCard accept(VisitorChanges v) {
		return v.visit(this);
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

	/**
	 * @return the card
	 */
	public PermissionCard getCard() {
		return card;
	}

}
