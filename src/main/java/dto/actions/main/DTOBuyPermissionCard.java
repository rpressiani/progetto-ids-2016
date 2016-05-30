package dto.actions.main;

import controller.VisitorActions;
import dto.actions.DTOAction;
import model.actions.main.BuyPermissionCard;
import model.player.Player;

public class DTOBuyPermissionCard implements DTOAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8750860032722062067L;

	@Override
	public BuyPermissionCard accept(VisitorActions v, Player player) {
		return v.visit(this);
	}

}
