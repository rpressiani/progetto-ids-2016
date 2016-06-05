package model.changes;

import dto.changes.DTOChangeElectCounsellorWithAssistant;
import model.map.Region;
import model.player.Assistants;
import model.player.Player;
import utilities.Color;
import view.VisitorChanges;

public class ChangeElectCounsellorWithAssistant implements Change {

	private Assistants assistants;
	private Color color;
	private Region region;
	
	public ChangeElectCounsellorWithAssistant(Assistants assistants, Color color, Region region) {
		this.assistants=assistants;
		this.color=color;
		this.region=region;
	}
	
	@Override
	public DTOChangeElectCounsellorWithAssistant accept(VisitorChanges v, Player player) {
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

	/**
	 * @return the region
	 */
	public Region getRegion() {
		return region;
	}

}
