package model.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.SimpleGraph;

import jaxb.CFGBonusTile;
import jaxb.CFGCity;
import jaxb.CFGRegion;
import model.bonusItem.BonusItem;
import model.council.GarbageState;
import parser.Parser;

/**
 * @author Alessandro Pezzotta
 *
 */
public class Map {
	
	private UndirectedGraph<City, DefaultEdge> map;
	private HashMap<String, CFGCity> allCitiesFromParser;
	private HashMap<String, City> allCitiesHashMap;
	private HashMap<String, Region> regions;
	
	/**
	 * constructor for Map
	 */
	public Map(Parser parser, GarbageState garbage) {
		this.map = new SimpleGraph<City, DefaultEdge>(DefaultEdge.class);
		this.allCitiesFromParser = new HashMap<String, CFGCity>();
		this.allCitiesHashMap = new HashMap<String, City>();
		this.regions = new HashMap<String, Region>();
		
		ArrayList<ArrayList<BonusItem>> bonusesList = new ArrayList<ArrayList<BonusItem>>();
		
		for (CFGBonusTile cfgBonusTile : parser.getCFGRoot().getMap().getBonusCityTiles().getBonusTile()) {
			ArrayList<BonusItem> tile = parser.getBonusesFromParser(cfgBonusTile.getBonuses().getBonus());
			bonusesList.add(tile);
		}
		
//		System.out.println(bonusesList);
//		ArrayList<BonusItem> bonusesArray = parser.getBonusesFromParser(parser.getCFGRoot().getMap().getBonusCityTiles().getBonusTile().get)
		
		List<CFGRegion> cfgRegions = parser.getCFGRoot().getMap().getRegion();
		
		for (Iterator<CFGRegion> iterator = cfgRegions.iterator(); iterator.hasNext();) {
			List<CFGCity> citiesToAdd = iterator.next().getCities().getCity();
			for (CFGCity cfgCity : citiesToAdd) {
				this.allCitiesFromParser.put(cfgCity.getName(), cfgCity);
				City cityToAdd;
				if (!cfgCity.getName().equals(parser.getCFGRoot().getMap().getKingInitLocation())) {
					Collections.shuffle(bonusesList);
//					System.out.println("ciao "+ bonusesList.size() + "\t"+ parser.getCFGRoot().getMap().getKingInitLocation()+"\t"+cfgCity.getName() + bonusesList);
					
					if (bonusesList.get(0) == null)
						throw new NullPointerException();
					
					ArrayList<BonusItem> bonuses = bonusesList.get(0);
					bonusesList.remove(0);
					cityToAdd = new City(cfgCity.getName(), cfgCity.getNameLong(), bonuses, cfgCity.getAncestry());
				} else {
					cityToAdd = new City(cfgCity.getName(), cfgCity.getNameLong(), new ArrayList<BonusItem>(), cfgCity.getAncestry());
				}
				
				this.allCitiesHashMap.put(cityToAdd.getName(), cityToAdd);
				this.map.addVertex(cityToAdd);
			}	
		}
		
		for (City city : this.allVertexes()) {
			for (Iterator<String> iterator = allCitiesFromParser.get(city.getName()).getLinks().getCityName().iterator();
					iterator.hasNext();) {
				String linkToAdd = iterator.next();
				this.addLink(city, allCitiesHashMap.get(linkToAdd));
			}
		}
		
		for (CFGRegion cfgRegion : cfgRegions) {
			this.regions.put(cfgRegion.getName(), new Region(cfgRegion.getName(), garbage, parser, this));
		}
	}
	/**
	 * @return the allCitiesHashMap
	 */
	public HashMap<String, City> getAllCitiesHashMap() {
		return allCitiesHashMap;
	}
	/**
	 * @param c 
	 * adds a city to the map 
	 */
	public void addCity(City c) {
		if(c==null) {
			throw new NullPointerException("A city cannot be null"); 
		}
		map.addVertex(c);
	}
	/**
	 * @param c1
	 * @param c2 
	 * adds a link between 2 cities
	 */
	public void addLink(City c1, City c2) {
		if(c1==null || c2==null) {
			throw new NullPointerException("Cities cannot be null"); 
		}
		map.addEdge(c1, c2);
	}
	/**
	 * @return the map
	 */
	public UndirectedGraph<City, DefaultEdge> getGraph() {
        return map;
	}
	//Dijkstra's algorithm, even if it's more of a BFS
	/**
	 * @param map
	 * @param c1 city 1
	 * @param c2 city 2
	 * @return shortest path between two input cities
	 */
	
	public List<DefaultEdge> shortestPath(UndirectedGraph<City, DefaultEdge> map, City c1, City c2) {
		if(map==null) {
			throw new NullPointerException("map cannot be null");  
		}
		if(c1==null || c2==null) {
			throw new NullPointerException("cities cannot be null"); 
		}
		DijkstraShortestPath<City, DefaultEdge> pathFinder = new DijkstraShortestPath<City, DefaultEdge>(map, c1, c2);
		List<DefaultEdge> path = pathFinder.getPathEdgeList();
		return path;
	}
	
	/**
	 * @param map
	 * @param c1
	 * @param c2
	 * @return numeric distance (#edges) between two cities 
	 */
	public int numericDistance(City c1, City c2) { 
		if(c1==null || c2==null) {
			throw new NullPointerException("cities cannot be null"); 
		}
		DijkstraShortestPath<City, DefaultEdge> pathFinder = new DijkstraShortestPath<City, DefaultEdge>(map, c1, c2);
		int distance = (int) pathFinder.getPathLength();
		return distance; 
	}

	/**
	 * @return all the cities on the map
	 */
	public Set<City> allVertexes() {
		Set<City> cities = this.map.vertexSet(); 
		return cities; 
	}
	/**
	 * @return the regions
	 */
	public HashMap<String, Region> getRegions() {
		return regions;
	}
	
	
		
} 
