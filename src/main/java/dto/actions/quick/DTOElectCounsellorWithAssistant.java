package dto.actions.quick;

import controller.VisitorActions;
import dto.utilities.DTOColor;
import model.actions.quick.ElectCounsellorWithAssistant;
import model.player.Player;

public class DTOElectCounsellorWithAssistant implements DTOQuickAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1369578544438130132L;
	
	private final String balcony;
	private final DTOColor color;
	
	/**
	 * @param balcony
	 * @param color
	 * @throws NullPointerException if region or color are null
	 */
	public DTOElectCounsellorWithAssistant(String balcony, DTOColor color) {
		if(balcony==null) {
			throw new NullPointerException("region cannot be null"); 
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
	public ElectCounsellorWithAssistant accept(VisitorActions v, Player player) {
		return v.visit(this);
	}

}
