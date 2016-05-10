package map;

import java.util.List;
import java.util.Set;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.SimpleGraph;

import player.Player;

public class Map {
	private UndirectedGraph<City, DefaultEdge> map;  
	private Set<City> cities; 
	public Map() {
		this.map = new SimpleGraph<City, DefaultEdge>(DefaultEdge.class);
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
	public int numericDistance(City c1, City c2) { 
		DijkstraShortestPath<City, DefaultEdge> pathFinder = new DijkstraShortestPath<City, DefaultEdge>(map, c1, c2);
		int distance = (int) pathFinder.getPathLength();
		return distance; 
	}
	public Set<City> allVertexes(UndirectedGraph<City, DefaultEdge> map) {
		cities = map.vertexSet(); 
		return cities; 
	}

	public Set<City> getCities() {
		return cities; 
	}

	public Set<City> allVertexes() {
		Set<City> cities = this.map.vertexSet(); 
		return cities; 
	}
	public boolean isDirectlyLinkedTo(City c1, City c2) {
		if(numericDistance(c1, c2)==1) 
			return true; 
		return false; 
	}
	//given a "conquered" city,  it returns all the connected cities conquered by player
	public Set<City> linkedCities(Player player, City c) {
		Set<City> linkedCities = null; 
		//player must have built somewhere
		if(player.getBuiltCities().contains(c)) {
			for(City city: player.getBuiltCities()) {
				if(isDirectlyLinkedTo(c, city)) {
					linkedCities.add(city);
				}
			}
		}
		return linkedCities; 
	}
} 

