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
	
	/**
	 * @param region
	 * @param color
	 * @throws NullPointerException if region or color are null
	 */
	public DTOElectCounsellor(DTORegion region, DTOColor color) {
		if(region==null) {
			throw new NullPointerException("region cannot be null"); 
		}
		if(color==null) {
			throw new NullPointerException("color cannot be null"); 
		}
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
