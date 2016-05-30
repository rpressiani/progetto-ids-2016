package dto.actions.quick;

import controller.VisitorActions;
import dto.actions.DTOAction;
import model.actions.GeneralAction;

public class DTOHireAssistant implements DTOAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -857615911131416134L;

	@Override
	public void accept(VisitorActions v) {
		v.visit(this);
	}

}
