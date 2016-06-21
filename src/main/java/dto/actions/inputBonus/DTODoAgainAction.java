package dto.actions.inputBonus;

import controller.VisitorActions;
import dto.actions.main.DTOMainAction;
import model.actions.inputBonus.DoAgainAction;
import model.player.Player;

public class DTODoAgainAction implements DTOInputBonusAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7897471784708180601L;

	private final DTOMainAction action;
	
	/**
	 * @param action
	 * @throws NullPointerException if action is null
	 */
	public DTODoAgainAction(DTOMainAction action) {
		if(action==null) {
			throw new NullPointerException("action cannot be null"); 
		}
		this.action = action;
	}
	
	public DTOMainAction getAction() {
		return action;
	}
	
	@Override
	public DoAgainAction accept(VisitorActions v, Player player) {
		return v.visit(this, player);
	}

}
