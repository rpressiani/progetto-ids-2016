package dto.actions.quick;

import controller.VisitorActions;
import dto.map.DTORegion;
import dto.utilities.DTOColor;
import model.actions.quick.ElectCounsellorWithAssistant;
import model.player.Player;

public class DTOElectCounsellorWithAssistant implements DTOQuickAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1369578544438130132L;
	
	private final DTORegion region;
	private final DTOColor color;
	
	public DTOElectCounsellorWithAssistant(DTORegion region, DTOColor color) {
		this.region = region;
		this.color = color;
	}

	/**
	 * @return the region
	 */
	public DTORegion getRegion() {
		return region;
	}

	/**
	 * @return the color
	 */
	public DTOColor getColor() {
		return color;
	}

	@Override
	public ElectCounsellorWithAssistant accept(VisitorActions v, Player player) {
		return v.visit(this);
	}

}
