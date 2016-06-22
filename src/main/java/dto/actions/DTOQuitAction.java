package dto.actions;

import controller.VisitorActions;
import model.actions.GeneralAction;
import model.player.Player;

public class DTOQuitAction implements DTOAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8659739824787429788L;

	@Override
	public GeneralAction accept(VisitorActions v, Player player) {
		return v.visit(this);
	}

}
