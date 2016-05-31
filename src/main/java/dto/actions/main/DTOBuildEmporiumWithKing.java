package dto.actions.main;

import controller.VisitorActions;
import dto.map.DTOCity;
import model.actions.main.BuildEmporiumWithKing;
import model.player.Player;

public class DTOBuildEmporiumWithKing implements DTOMainAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8375878787412851301L;

	//private final DTOPoliticalContainer proposal;
	private final DTOCity city;
	
	public DTOBuildEmporiumWithKing(DTOCity city){
		this.city=city;
	}
	
	/**
	 * @return the city
	 */
	public DTOCity getCity() {
		return city;
	}
	
	@Override
	public BuildEmporiumWithKing accept(VisitorActions v, Player player) {
		return v.visit(this, player);
	}

}
