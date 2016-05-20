package model.bonusable;

import java.util.ArrayList;

import model.bonusItem.BonusItem;
import utilities.Color;

public class ColorCard extends Bonusable {

	private Color color;
	
	public ColorCard(ArrayList<BonusItem> bonuses, Color color) {
		super(bonuses);
		this.color=color;
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

}
