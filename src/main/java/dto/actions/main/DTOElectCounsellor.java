package dto.actions.main;

import controller.VisitorActions;
import dto.map.DTORegion;
import dto.utilities.DTOColor;
import model.actions.main.ElectCounsellor;
import model.player.Player;

public class DTOElectCounsellor implements DTOMainAction {
	
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
	public ElectCounsellor accept(VisitorActions v, Player player) {
		return v.visit(this);
	}

}
