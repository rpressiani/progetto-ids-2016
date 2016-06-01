package dto.actions.main;

import controller.VisitorActions;
import dto.map.DTORegion;
import dto.utilities.DTOPoliticalContainer;
import model.actions.main.BuyPermissionCard;
import model.player.Player;

public class DTOBuyPermissionCard implements DTOMainAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8750860032722062067L;

	private final DTORegion region;
	private final DTOPoliticalContainer proposal;
	private final int index;
	
	public DTOBuyPermissionCard(DTORegion region, DTOPoliticalContainer proposal, int index) {
		this.region=region;
		this.proposal=proposal;
		this.index=index;
	}
	
	public DTORegion getRegion() {
		return region;
	}

	public DTOPoliticalContainer getProposal() {
		return proposal;
	}

	public int getIndex() {
		return index;
	}
	
	@Override
	public BuyPermissionCard accept(VisitorActions v, Player player) {
		return v.visit(this, player);
	}

}
