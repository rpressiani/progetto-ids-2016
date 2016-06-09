package dto.actions.main;

import controller.VisitorActions;
import dto.map.DTOCity;
import dto.utilities.DTOPermissionCardSelection;
import model.actions.main.BuildEmporiumWithCard;
import model.player.Player;

public class DTOBuildEmporiumWithCard implements DTOMainAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 85255788780648973L;
	
	private final DTOPermissionCardSelection permissionCard;
	private final DTOCity city;
	
	/**
	 * @param permissionCard
	 * @param city
	 * @throws NullPointerException if permissionCard or city are null
	 */
	public DTOBuildEmporiumWithCard(DTOPermissionCardSelection permissionCard, DTOCity city) {
		if(permissionCard==null) {
			throw new NullPointerException("permissionCard cannot be null"); 
		}
		if(city==null) {
			throw new NullPointerException("city cannot be null"); 
		}
		this.permissionCard = permissionCard;
		this.city = city;
	}

	/**
	 * @return the permissionCard
	 */
	public DTOPermissionCardSelection getPermissionCard() {
		return permissionCard;
	}

	/**
	 * @return the city
	 */
	public DTOCity getCity() {
		return city;
	}

	@Override
	public BuildEmporiumWithCard accept(VisitorActions v, Player player) {
		return v.visit(this, player);
	}

}
