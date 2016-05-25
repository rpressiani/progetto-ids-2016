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
	 * @throws NullPointerException if parser or map are null
	 */
	public King(Parser parser, Map map) {
		if(parser==null) {
			throw new NullPointerException("parser cannot be null"); 
		}
		if(map==null) {
			throw new NullPointerException("map cannot be null"); 
		}
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
	 * @throws NullPointerException if kingCity is null
	 */
	public void setKingCity(City kingCity) {
		if(kingCity==null) {
			throw new NullPointerException("kingCity cannot be null"); 
		}
		this.kingCity = kingCity;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "King [kingCity=" + kingCity + "]";
	}
	
}
