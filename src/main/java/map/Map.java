package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.SimpleGraph;

import jaxb.CFGBonus;
import jaxb.CFGCity;
import jaxb.CFGRegion;
import parser.Parser;
import bonusItem.BonusItem;

public class Map {
	
	private UndirectedGraph<City, DefaultEdge> map;
	private HashMap<String, CFGCity> allCitiesFromParser;
	private HashMap<String, City> allCitiesHashMap;
	
	/**
	 * constructor for Map
	 */
	public Map(Parser parser) {
		this.map = new SimpleGraph<City, DefaultEdge>(DefaultEdge.class);
		this.allCitiesFromParser = new HashMap<String, CFGCity>();
		this.allCitiesHashMap = new HashMap<String, City>();
		
		List<CFGRegion> cfgRegions = parser.getCFGRoot().getMap().getRegion();
		
		for (Iterator<CFGRegion> iterator = cfgRegions.iterator(); iterator.hasNext();) {
			List<CFGCity> citiesToAdd = iterator.next().getCities().getCity();
			for (CFGCity cfgCity : citiesToAdd) {
				this.allCitiesFromParser.put(cfgCity.getName(), cfgCity);
				List<CFGBonus> cfgCityBonuses = cfgCity.getBonuses().getBonus();
				ArrayList<BonusItem> bonuses = parser.getBonusesFromParser(cfgCityBonuses);
				City cityToAdd = new City(cfgCity.getName(), bonuses, cfgCity.getAncestry());
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

	}
	/**
	 * @param c adds a city to the map 
	 */
	public void addCity(City c) {
		map.addVertex(c);
	}
	/**
	 * @param c1
	 * @param c2 adds a link between 2 cities
	 */
	public void addLink(City c1, City c2) {
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
	 * @param c1
	 * @param c2
	 * @return shortest path between two input cities
	 */
	
	public List<DefaultEdge> shortestPath(UndirectedGraph<City, DefaultEdge> map, City c1, City c2) {
		if(map==null) {
			return null; 
		}
		DijkstraShortestPath<City, DefaultEdge> pathFinder = new DijkstraShortestPath<City, DefaultEdge>(map, c1, c2);
		List<DefaultEdge> path = pathFinder.getPathEdgeList();
		return path;
	}
	
	public int numericDistance(UndirectedGraph<City, DefaultEdge> map, City c1, City c2) { 
		DijkstraShortestPath<City, DefaultEdge> pathFinder = new DijkstraShortestPath<City, DefaultEdge>(map, c1, c2);
		int distance = (int) pathFinder.getPathLength();
		return distance; 
	}

	public Set<City> allVertexes() {
		Set<City> cities = this.map.vertexSet(); 
		return cities; 
	}
	
} 
