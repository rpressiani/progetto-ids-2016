package dto.actions.quick;

import controller.VisitorActions;
import model.actions.quick.HireAssistant;
import model.player.Player;

public class DTOHireAssistant implements DTOQuickAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -857615911131416134L;

	@Override
	public HireAssistant accept(VisitorActions v, Player player) {
		return v.visit(this);
	}

}
