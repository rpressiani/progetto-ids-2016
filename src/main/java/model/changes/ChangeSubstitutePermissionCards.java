package model.changes;

import dto.changes.DTOChangeSubstitutePermissionCards;
import model.map.Region;
import model.player.Assistants;
import view.VisitorChanges;

public class ChangeSubstitutePermissionCards implements Change {

	private Assistants assistants;
	private Region region;

	/**
	 * @param assistants
	 * @param region
	 * @throws NullPointerException if assistants or region are null
	 */
	public ChangeSubstitutePermissionCards(Assistants assistants, Region region){
		if(assistants==null) {
			throw new NullPointerException("assistants cannot be null"); 
		}
		if(region==null) {
			throw new NullPointerException("region cannot be null"); 
		}
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
