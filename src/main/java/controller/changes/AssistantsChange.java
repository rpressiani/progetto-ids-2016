package controller.changes;

import model.player.Assistants;

public class AssistantsChange extends ItemChange {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1386813079286705820L;
	private Assistants newAssistants; 
	
	public AssistantsChange(Assistants newAssistants) {
		super(newAssistants); 
	}

}
