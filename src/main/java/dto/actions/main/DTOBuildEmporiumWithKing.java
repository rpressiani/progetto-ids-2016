package dto.actions.main;

import controller.VisitorActions;
import model.actions.main.BuildEmporiumWithKing;
import model.player.Player;

public class DTOBuildEmporiumWithKing implements DTOMainAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8375878787412851301L;

	@Override
	public BuildEmporiumWithKing accept(VisitorActions v, Player player) {
		return v.visit(this, player);
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
