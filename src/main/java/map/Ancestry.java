package map;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import bonusItem.BonusItem;
import bonusable.ColorCard;
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
		if (!checkAncestryColor.contains(color)) throw new IllegalArgumentException("This ancestry color is not defined in the configuration file");
		this.color = color;
		
		for (City city : map.allVertexes()) {
			if (city.getAncestry() == this.color.getStringID()) this.getColorCities().add(city);
		}
		
		int ancestryIndex = -1;
		for (int i = 0; i < parser.getCFGRoot().getMap().getAncestries().getAncestry().size(); i++) {
			if (this.color.getStringID() == parser.getCFGRoot().getMap().getAncestries().getAncestry().get(ancestryIndex).getColor()) {
				ancestryIndex = i;
				break;
			}
		}
		ArrayList<BonusItem> bonuses = new ArrayList<BonusItem>();
		bonuses = parser.getBonusesFromParser(parser.getCFGRoot().getMap().getAncestries().getAncestry().get(ancestryIndex).getBonuses().getBonus());
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
	
}
