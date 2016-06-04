package model.changes;

import dto.changes.DTOChangeSubstitutePermissionCards;
import model.player.Assistants;
import model.player.Player;
import view.VisitorChanges;

public class ChangeSubstitutePermissionCards implements Change {

	private Assistants assistants;
	private String nameRegion;

	public ChangeSubstitutePermissionCards(Assistants assistants, String nameRegion){
		this.assistants=assistants;
		this.nameRegion=nameRegion;
	}
	
	@Override
	public DTOChangeSubstitutePermissionCards accept(VisitorChanges v, Player player) {
		return v.visit(this);
	}

	/**
	 * @return the assistants
	 */
	public Assistants getAssistants() {
		return assistants;
	}
	
	/**
	 * @return the region
	 */
	public String getNameRegion() {
		return nameRegion;
	}
}
