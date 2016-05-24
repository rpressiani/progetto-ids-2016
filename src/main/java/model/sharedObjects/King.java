package model.sharedObjects;

import model.map.City;
import model.map.Map;
import parser.Parser;

public class King {
	
	private City kingCity;
	
	/**
	 * create the king
	 * @param parser can't be null
	 * @param map can't be null
	 */
	public King(Parser parser, Map map){
		this.kingCity = map.getAllCitiesHashMap().get(parser.getCFGRoot().getMap().getKingInitLocation());
	}

	/**
	 * 
	 * @return the king
	 */
	public City getKingCity() {
		return kingCity;
	}

	/**
	 * set the king in a city
	 * @param kingCity can't be null
	 */
	public void setKingCity(City kingCity) {
		this.kingCity = kingCity;
	}
	
}
