package dto.actions.quick;

import dto.actions.DTOAction;

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

}
