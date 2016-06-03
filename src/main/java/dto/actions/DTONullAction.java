package dto.actions;

import controller.VisitorActions;
import model.actions.NullAction;
import model.player.Player;

public class DTONullAction implements DTOAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5471579905912493897L;

	@Override
	public NullAction accept(VisitorActions v, Player player) {
		return v.visit(this);
	}

}
