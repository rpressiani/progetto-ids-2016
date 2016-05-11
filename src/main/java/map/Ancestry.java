package map;

import java.util.Set;

import bonusable.ColorCard;
import parser.Parser;
import utilities.Color;

public class Ancestry {
	
	private Color color;
	private Set<City> colorCities;
	private ColorCard colorBonus;
	
	public Ancestry(Color color, Parser parser, Map map){
		
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
