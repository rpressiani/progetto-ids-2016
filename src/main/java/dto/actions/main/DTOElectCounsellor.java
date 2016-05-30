package dto.actions.main;

import controller.VisitorActions;
import dto.actions.DTOAction;
import dto.map.DTORegion;
import dto.utilities.DTOColor;
import model.actions.GeneralAction;

public class DTOElectCounsellor implements DTOAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8997763321000061932L;
	private final DTORegion region;
	private final DTOColor color;
	
	public DTOElectCounsellor(DTORegion region, DTOColor color) {
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
