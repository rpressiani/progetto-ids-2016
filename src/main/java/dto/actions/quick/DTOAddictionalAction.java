package dto.actions.quick;

import controller.VisitorActions;
import dto.actions.DTOAction;
import model.actions.quick.AddictionalAction;
import model.player.Player;

public class DTOAddictionalAction implements DTOAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6952651971726939163L;
	
	private final DTOAction action;
	
	public DTOAddictionalAction(DTOAction action) {
		this.action = action;
	}

	/**
	 * @return the action
	 */
	public DTOAction getAction() {
		return action;
	}

	@Override
	public AddictionalAction accept(VisitorActions v, Player player) {
		return v.visit(this);
	}

}
