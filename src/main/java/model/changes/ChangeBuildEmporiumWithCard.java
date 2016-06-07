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
	
	/**
	 * @param assistants
	 * @param city
	 * @param card
	 * @throws NullPointerException if assistants, city or card are null
	 */
	public ChangeBuildEmporiumWithCard(Assistants assistants, City city, PermissionCard card) {
		if(assistants==null) {
			throw new NullPointerException("assistants cannot be null"); 
		}
		if(city==null) {
			throw new NullPointerException("city cannot be null"); 
		}
		if(card==null) {
			throw new NullPointerException("card cannot be null"); 
		}
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
