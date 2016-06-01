package dto.actions.main;

import controller.VisitorActions;
import dto.map.DTOCity;
import dto.utilities.DTOPoliticalContainer;
import model.actions.main.BuildEmporiumWithKing;
import model.player.Player;

public class DTOBuildEmporiumWithKing implements DTOMainAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8375878787412851301L;
	
	private final DTOPoliticalContainer proposal;
	private final DTOCity city;
	
	public DTOBuildEmporiumWithKing(DTOPoliticalContainer proposal, DTOCity city){
		this.proposal=proposal;
		this.city=city;
	}
	
	/**
	 * 
	 * @return the proposal
	 */
	public DTOPoliticalContainer getProposal() {
		return proposal;
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
