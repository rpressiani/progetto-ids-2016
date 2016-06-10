package model.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.SimpleGraph;

import jaxb.CFGAncestry;
import jaxb.CFGBonusTile;
import jaxb.CFGCity;
import jaxb.CFGRegion;
import model.bonusItem.BonusItem;
import model.council.GarbageState;
import model.sharedObjects.King;
import parser.Parser;
import utilities.Color;

/**
 * @author Alessandro Pezzotta
 *
 */
public class Map {
	
	private UndirectedGraph<City, DefaultEdge> map;
	private HashMap<String, CFGCity> allCitiesFromParser;
	private HashMap<String, City> allCitiesHashMap;
	private HashMap<String, Region> regions;
	private HashMap<String, Ancestry> ancestries;
	private final String cliDisplay;
	
	private King king;
	
	/**
	 * constructor for Map
	 */
	public Map(Parser parser, GarbageState garbage) {
		if(parser==null) {
			throw new NullPointerException("cannot have a null parser");
		}
		if(garbage==null) {
			throw new NullPointerException("cannot have a null garbage state");
		}
		this.map = new SimpleGraph<City, DefaultEdge>(DefaultEdge.class);
		this.allCitiesFromParser = new HashMap<String, CFGCity>();
		this.allCitiesHashMap = new HashMap<String, City>();
		this.regions = new HashMap<String, Region>();
		this.ancestries = new HashMap<String, Ancestry>();
		this.cliDisplay = parser.getCFGRoot().getMap().getCliDisplay();
		
//		BONUS TILES GENERATION
		
		ArrayList<ArrayList<BonusItem>> bonusesList = new ArrayList<ArrayList<BonusItem>>();
		
		for (CFGBonusTile cfgBonusTile : parser.getCFGRoot().getMap().getBonusCityTiles().getBonusTile()) {
			ArrayList<BonusItem> tile = parser.getBonusesFromParser(cfgBonusTile.getBonuses().getBonus());
			bonusesList.add(tile);
		}
		
//		REGIONS HASHMAP GENERATION
		
		List<CFGRegion> cfgRegions = parser.getCFGRoot().getMap().getRegion();
		
		for (CFGRegion cfgRegion : cfgRegions) {
			this.regions.put(cfgRegion.getName(), new Region(cfgRegion.getName(), garbage, parser, this));
		}
		
//		ANCESTRIES HASHMAP GENERATION
		
		List<CFGAncestry> cfgAncestries  = parser.getCFGRoot().getMap().getAncestries().getAncestry();
		
		for (CFGAncestry cfgAncestry : cfgAncestries) {
			this.ancestries.put(cfgAncestry.getColor(), new Ancestry(new Color(cfgAncestry.getColor()), parser, this));
		}
		
//		CITIES GENERATION
		
		Ancestry tmpAncestry;
		ArrayList<BonusItem> tmpBonuses;
		City cityToAdd;
		Region tmpRegion;
		
		for (Iterator<CFGRegion> iterator = cfgRegions.iterator(); iterator.hasNext();) {	//
			CFGRegion cfgRegion = iterator.next();
			List<CFGCity> citiesToAdd = cfgRegion.getCities().getCity();
			for (CFGCity cfgCity : citiesToAdd) {
				this.allCitiesFromParser.put(cfgCity.getName(), cfgCity);
				
				tmpRegion = this.regions.get(cfgRegion.getName());
				
//				BONUS TILE ASSOCIATION
				if (!cfgCity.getName().equals(parser.getCFGRoot().getMap().getKingInitLocation())) {
					tmpAncestry = this.ancestries.get(cfgCity.getAncestry());
					Collections.shuffle(bonusesList);
//					System.out.println("ciao "+ bonusesList.size() + "\t"+ parser.getCFGRoot().getMap().getKingInitLocation()+"\t"+cfgCity.getName() + bonusesList);
					
					if (bonusesList.get(0) == null)
						throw new NullPointerException();
					
					tmpBonuses = bonusesList.get(0);
					bonusesList.remove(0);
					
//					CITY CREATION 
					
					cityToAdd = new City(cfgCity.getName(), cfgCity.getNameLong(), tmpBonuses, tmpRegion, tmpAncestry);
					
				} else {
					tmpAncestry = new Ancestry();
					tmpBonuses = new ArrayList<BonusItem>();
					cityToAdd = new City(cfgCity.getName(), cfgCity.getNameLong(), tmpBonuses, tmpRegion, tmpAncestry);
				}
				
				this.allCitiesHashMap.put(cityToAdd.getName(), cityToAdd);
				this.map.addVertex(cityToAdd);
			}	
		}
		
//		LINKS GENERATION
		
		for (City city : this.allVertexes()) {
			for (Iterator<String> iterator = allCitiesFromParser.get(city.getName()).getLinks().getCityName().iterator();
					iterator.hasNext();) {
				String linkToAdd = iterator.next();
				this.addLink(city, allCitiesHashMap.get(linkToAdd));
			}
		}
		
		List<City> cities = new ArrayList<City>(this.getAllCitiesHashMap().values());
		
//		REGION INIT
		for (Entry<String, Region> entry : this.regions.entrySet()) {
			entry.getValue().initRegion(cities);
		}
		
//		ANCESTRY INIT
		for (Entry<String, Ancestry> entry : this.ancestries.entrySet()){
			entry.getValue().initAncestry(cities, parser.getCFGRoot().getMap().getKingInitLocation());
		}
		
//		KING GENERATION
		this.king = new King(parser, this);
		
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
	 * @throws NullPointerException if c is null
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
	 * @throws NullPointerException if c1 or c2 is null
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
	 * @throws NullPointerException if map is null
	 * @throws NullPointerException if c1 or c2 is null
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


	/**
	 * @return the ancestries
	 */
	public HashMap<String, Ancestry> getAncestries() {
		return ancestries;
	}


	/**
	 * @return the king
	 */
	public King getKing() {
		return king;
	}


	/**
	 * @return the cliDisplay
	 */
	public String getCliDisplay() {
		return cliDisplay;
	}
	
	
		
} 
