package dto.actions.quick;

import controller.VisitorActions;
import dto.actions.main.DTOMainAction;
import model.actions.quick.AddictionalAction;
import model.player.Player;

public class DTOAddictionalAction implements DTOQuickAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6952651971726939163L;
	
	private final DTOMainAction action;
	
	/**
	 * @param action
	 * @throws NullPointerException if action is null
	 */
	public DTOAddictionalAction(DTOMainAction action) {
		if(action==null) {
			throw new NullPointerException("action cannot be null"); 
		}
		this.action = action;
	}

	/**
	 * @return the action
	 */
	public DTOMainAction getAction() {
		return action;
	}

	@Override
	public AddictionalAction accept(VisitorActions v, Player player) {
		return v.visit(this, player);
	}

}
