package dto.actions.main;

import controller.VisitorActions;
import dto.actions.DTOAction;
import dto.map.DTOCity;
import model.actions.GeneralAction;

public class DTOBuildEmporiumWithKing implements DTOAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8375878787412851301L;

	@Override
	public void accept(VisitorActions v) {
		v.visit(this);
	}
	
	//private final DTOPoliticalDeck proposal;
	//private final DTOCity city;

	/**
	 * @return the city
	 */
	/*public DTOCity getCity() {
		return city;
	}*/

}
