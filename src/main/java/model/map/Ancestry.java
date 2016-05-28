package model.map;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import model.bonusItem.BonusItem;
import model.bonusable.ColorCard;
import parser.Parser;
import utilities.Color;

public class Ancestry {
	
	private Color color;
	private Set<City> colorCities;
	private ColorCard colorBonus;
	
	public Ancestry(Color color, Parser parser, Map map) throws IllegalArgumentException {
		HashSet<String> checkAncestryColor = new HashSet<String>();
		
		for (int i = 0; i < parser.getCFGRoot().getMap().getAncestries().getAncestry().size(); i++) {
			checkAncestryColor.add(parser.getCFGRoot().getMap().getAncestries().getAncestry().get(i).getColor());
		}
		
		if (!checkAncestryColor.contains(color.getStringID()))
			throw new IllegalArgumentException("This ancestry color is not defined in the configuration file");
		
		this.color = color;
		
		int ancestryIndex = -1;
		for (int i = 0; i < parser.getCFGRoot().getMap().getAncestries().getAncestry().size(); i++) {
			if (this.color.getStringID().equals(parser.getCFGRoot().getMap().getAncestries().getAncestry().get(i).getColor())) {
				ancestryIndex = i;
				break;
			}
		}
		ArrayList<BonusItem> bonuses = parser.getBonusesFromParser(
				parser.getCFGRoot().getMap().getAncestries().getAncestry().get(ancestryIndex).getBonuses().getBonus());
		this.colorBonus = new ColorCard(bonuses, this.color);
	}
	
	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}
	/**
	 * @return the colorCities
	 */
	public Set<City> getColorCities() {
		return colorCities;
	}
	/**
	 * @return the colorBonus
	 */
	public ColorCard getColorBonus() {
		return colorBonus;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ancestry [color=" + color + ", colorBonus=" + colorBonus + "]";
	}
	
}
