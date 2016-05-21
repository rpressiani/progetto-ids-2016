package model.sharedObjects;

import model.map.City;
import model.map.Map;
import parser.Parser;

public class King {
	
	private City kingCity;
	
	public King(Parser parser, Map map){
		
		for (City city : map.allVertexes()) {
			if (city.getName() == parser.getCFGRoot().getMap().getKingInitLocation()) {
				this.kingCity = city;
				break;
			}
		}
	}

	public City getKingCity() {
		return kingCity;
	}

	public void setKingCity(City kingCity) {
		this.kingCity = kingCity;
	}
	
}
