package model.changes;

import dto.changes.DTOChangeElectCounsellorWithAssistant;
import model.player.Assistants;
import utilities.Color;
import view.VisitorChanges;

public class ChangeElectCounsellorWithAssistant implements Change {

	private Assistants assistants;
	private Color color;
	
	public ChangeElectCounsellorWithAssistant(Assistants assistants, Color color) {
		if(color==null) {
			throw new NullPointerException("coins cannot be null"); 
		}
		if(assistants==null) {
			throw new NullPointerException("assistants cannot be null"); 
		}

		this.assistants=assistants;
		this.color=color;
	}
	
	@Override
	public DTOChangeElectCounsellorWithAssistant accept(VisitorChanges v) {
		return v.visit(this);
	}

	/**
	 * @return the assistants
	 */
	public Assistants getAssistants() {
		return assistants;
	}

	/**
	 * @return the colorAssistant
	 */
	public Color getColor() {
		return color;
	}

}
