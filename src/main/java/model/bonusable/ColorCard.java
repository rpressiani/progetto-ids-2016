package model.bonusable;

import java.util.ArrayList;

import model.bonusItem.BonusItem;
import utilities.Color;

public class ColorCard extends Bonusable {

	private Color color;
	
	/**
	 * create the color card
	 * @param bonuses can't be null
	 * @param color can't be null
	 * @throws NullPointerException if color is null
	 */
	public ColorCard(ArrayList<BonusItem> bonuses, Color color) {
		super(bonuses);
		if(color==null) {
			throw new NullPointerException("color cannot be null"); 
		}
		this.color=color;
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

}
