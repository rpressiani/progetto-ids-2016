package model.map;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.bonusItem.BonusItem;
import model.bonusable.ColorCard;
import parser.Parser;
import utilities.Color;

public class Ancestry {
	
	private Color color;
	private Set<City> colorCities;
	private ColorCard colorCard;
	
	/**
	 * Constructor
	 * @param color
	 * @param parser
	 * @param map
	 * @throws NullPointerException if one of the parameters is null
	 */
	public Ancestry(Color color, Parser parser, Map map) {
		if(color==null) {
			throw new NullPointerException("color cannot be null"); 
		}
		if(parser==null) {
			throw new NullPointerException("parser cannot be null"); 
		}
		if(map==null) {
			throw new NullPointerException("map cannot be null"); 
		}
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
		this.colorCard = new ColorCard(bonuses, this.color);
		
		this.colorCities = new HashSet<City>();
	}
	
	/**
	 * Constructor
	 */
	public Ancestry() {
		this.color = new Color("king");
		this.colorCities = new HashSet<City>();
		this.colorCard = new ColorCard(new ArrayList<BonusItem>(), this.color);
		
	}
	
	/**
	 * @param cities
	 * @param kingInitLoc
	 * initializes the ancestries with parameters from file
	 */
	public void initAncestry(List<City> cities, String kingInitLoc) {
		
		for (City city : cities) {
			if (city.getName().equals(kingInitLoc)) {
				continue;
			}
			if (city.getAncestry().getColor().getStringID().equals(this.getColor().getStringID())) {
				this.colorCities.add(city);
			}
		}
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
	public ColorCard getColorCard() {
		return colorCard;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ancestry [color=" + color + ", colorBonus=" + colorCard + "]";
	}
	
}
