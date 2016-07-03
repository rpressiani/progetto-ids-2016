package dto.actions.main;

import controller.VisitorActions;
import dto.utilities.DTOColor;
import model.actions.main.ElectCounsellor;
import model.player.Player;

public class DTOElectCounsellor implements DTOMainAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8997763321000061932L;
	private final String balcony;
	private final DTOColor color;
	
	/**
	 * @param balcony
	 * @param color
	 * @throws NullPointerException if region or color are null
	 */
	public DTOElectCounsellor(String balcony, DTOColor color) {
		if(balcony==null) {
			throw new NullPointerException("balcony cannot be null"); 
		}
		if(color==null) {
			throw new NullPointerException("color cannot be null"); 
		}
		this.balcony = balcony;
		this.color = color;
	}

	/**
	 * @return the balcony
	 */
	public String getBalcony() {
		return balcony;
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
