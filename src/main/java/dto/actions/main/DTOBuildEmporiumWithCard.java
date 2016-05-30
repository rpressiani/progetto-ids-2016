package dto.actions.main;

import controller.VisitorActions;
import dto.actions.DTOAction;
import dto.map.DTOCity;
import dto.utilities.DTOPermissionCard;
import model.actions.GeneralAction;

public class DTOBuildEmporiumWithCard implements DTOAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 85255788780648973L;
	
	private final DTOPermissionCard permissionCard;
	private final DTOCity city;
	
	public DTOBuildEmporiumWithCard(DTOPermissionCard permissionCard, DTOCity city) {
		this.permissionCard = permissionCard;
		this.city = city;
	}

	/**
	 * @return the permissionCard
	 */
	public DTOPermissionCard getPermissionCard() {
		return permissionCard;
	}

	/**
	 * @return the city
	 */
	public DTOCity getCity() {
		return city;
	}

	@Override
	public void accept(VisitorActions v) {
		v.visit(this);
	}

}
