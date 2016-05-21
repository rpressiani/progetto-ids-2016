package model.sharedObjects;

import model.map.City;
import model.map.Map;
import parser.Parser;

public class King {
	
	private City kingCity;
	
	public King(Parser parser, Map map){
		this.kingCity = map.getAllCitiesHashMap().get(parser.getCFGRoot().getMap().getKingInitLocation());
	}

	public City getKingCity() {
		return kingCity;
	}

	public void setKingCity(City kingCity) {
		this.kingCity = kingCity;
	}
	
}
