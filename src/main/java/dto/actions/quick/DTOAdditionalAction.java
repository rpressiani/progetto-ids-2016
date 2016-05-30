package dto.actions.quick;

import controller.VisitorActions;
import dto.actions.DTOAction;
import model.actions.GeneralAction;

public class DTOAdditionalAction implements DTOAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6952651971726939163L;
	
	private final DTOAction action;
	
	public DTOAdditionalAction(DTOAction action) {
		this.action = action;
	}

	/**
	 * @return the action
	 */
	public DTOAction getAction() {
		return action;
	}

	@Override
	public void accept(VisitorActions v) {
		v.visit(this);
	}

}
