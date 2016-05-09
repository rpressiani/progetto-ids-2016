package map;
import java.util.List;
import java.util.Set;

import org.jgraph.JGraph;
import org.jgraph.graph.DefaultEdge;
import org.jgraph.graph.DefaultGraphCell;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.graph.builder.UndirectedGraphBuilder;
import player.Player;

public class Map {
	private UndirectedGraph<City, DefaultEdge> map;  
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
	/*public List<City> hasBuiltThere(Player player) {
		
		 List<City> conqueredCities = new BreadthFirstIterator<>(); ?
		 should need a boolean "hasBuiltThere in class City.java"
	}*/
	
} 

