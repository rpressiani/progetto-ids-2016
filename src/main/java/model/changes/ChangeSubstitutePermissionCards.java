package model.changes;

import dto.changes.DTOChangeSubstitutePermissionCards;
import model.map.Region;
import model.player.Assistants;
import view.VisitorChanges;

public class ChangeSubstitutePermissionCards implements Change {

	private Assistants assistants;
	private Region region;

	public ChangeSubstitutePermissionCards(Assistants assistants, Region region){
		this.assistants=assistants;
		this.region=region;
	}
	
	@Override
	public DTOChangeSubstitutePermissionCards accept(VisitorChanges v) {
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
	public Region getRegion() {
		return region;
	}
}
