package model.changes;

import dto.changes.DTOChangeElectCounsellor;
import model.player.Coins;
import utilities.Color;
import view.VisitorChanges;

public class ChangeElectCounsellor implements Change {

	private Coins coins;
	private Color color;
	
	/**
	 * @param coins
	 * @param color
	 * @param region
	 * @throws NullPointerException if coins, color or region are null
	 */
	public ChangeElectCounsellor(Coins coins, Color color) {
		if(coins==null) {
			throw new NullPointerException("coins cannot be null"); 
		}
		if(color==null) {
			throw new NullPointerException("color cannot be null"); 
		}
		
		this.coins=coins;
		this.color=color;
	}
	
	@Override
	public DTOChangeElectCounsellor accept(VisitorChanges v) {
		return v.visit(this);
	}

	/**
	 * @return the coins
	 */
	public Coins getCoins() {
		return coins;
	}
	
	/**
	 * @return the colorAssistant
	 */
	public Color getColor() {
		return color;
	}

}
