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
	
	/**
	 * @param proposal
	 * @param city
	 * @throws NullPointerException if proposal or city are null
	 */
	public DTOBuildEmporiumWithKing(DTOPoliticalContainer proposal, DTOCity city) {
		if(proposal==null) {
			throw new NullPointerException("proposal cannot be null"); 
		}
		if(city==null) {
			throw new NullPointerException("city cannot be null"); 
		}
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
