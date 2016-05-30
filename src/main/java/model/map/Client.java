package model.map;

import java.util.Map.Entry;

import model.council.GarbageState;
import model.sharedObjects.King;
import parser.Parser;

public class Client {

	public static void main(String[] args) {
		Parser parser = new Parser();
		GarbageState garbage = new GarbageState(parser);
		Map map = new Map(parser, garbage);
		
//		System.out.println(map.getAncestries());
		
//		System.out.println(map.getAllCitiesHashMap());
		
		for (Entry<String, Ancestry> entry : map.getAncestries().entrySet()) {
			System.out.println(entry.getValue().getColor().getStringID());
			System.out.println(entry.getValue().getColorCities());
		}
		
		for (Entry<String, Region> entry : map.getRegions().entrySet()) {
			System.out.println(entry.getValue().getRegionCities());
		}
		
//		King king = new King(parser, map);
//		System.out.println(king);

	}

}
