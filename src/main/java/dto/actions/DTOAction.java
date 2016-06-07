package dto.actions;

import controller.VisitorActions;
import dto.DTOObject;
import model.actions.GeneralAction;
import model.player.Player;

public interface DTOAction extends DTOObject {
	/**
	 * 
	 * @param v
	 * @param player
	 * @return the action visited by visitor
	 */
	public GeneralAction accept(VisitorActions v, Player player);
}
