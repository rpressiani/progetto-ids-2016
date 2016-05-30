package dto.actions.quick;

import controller.VisitorActions;
import dto.actions.DTOAction;
import dto.map.DTORegion;
import dto.utilities.DTOColor;
import model.actions.GeneralAction;

public class DTOElectCounsellorWithAssistant implements DTOAction {

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
	public void accept(VisitorActions v) {
		v.visit(this);
	}

}
