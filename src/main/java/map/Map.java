package map;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.SimpleGraph;

import bonusItem.BonusItem;
import jaxb.CFGBonus;
import jaxb.CFGCity;
import jaxb.CFGRegion;
import parser.Parser;

public class Map {
	
	private UndirectedGraph<City, DefaultEdge> map;  
	
	public Map(Parser parser) {
		this.map = new SimpleGraph<City, DefaultEdge>(DefaultEdge.class);
		
//		public City(String name, ArrayList<BonusItem> bonuses, HashSet<City> nearCities);
		
		List<CFGRegion> cfgRegions = parser.getCFGRoot().getMap().getRegion();
		
		for (Iterator<CFGRegion> iterator = cfgRegions.iterator(); iterator.hasNext();) {
			List<CFGCity> citiesToAdd = iterator.next().getCities().getCity();
			for (CFGCity cfgCity : citiesToAdd) {
				List<CFGBonus> cfgCityBonuses = cfgCity.getBonuses().getBonus();
				ArrayList<BonusItem> bonuses = parser.getBonusesFromParser(cfgCityBonuses);
				this.map.addVertex(new City(cfgCity.getName(), bonuses));
			}
			
		}
		
	}
	
	public void addCity(City c) {
		map.addVertex(c);
	}
	
	public void addLink(City c1, City c2) {
		map.addEdge(c1, c2);
	}
	
	public UndirectedGraph<City, DefaultEdge> getGraph() {
        return map;
	}
	
	//Dijkstra's algorithm, even if it's more of a BFS
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

