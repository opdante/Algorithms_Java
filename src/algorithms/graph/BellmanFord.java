package algorithms.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data_structures.graph.Edge;
import data_structures.graph.Node;
import data_structures.graph.WeightedGraph;

/**
 * 
 * @author Thabang
 * 
 * Given a graph and a source vertex src in graph, the Bellman Ford shortest 
 * path algorithm finds the shortest paths from src to all vertices in the 
 * given graph. The graph may contain negative weight edges.
 * See : http://www.geeksforgeeks.org/dynamic-programming-set-23-bellman-ford-algorithm/
 */
public class BellmanFord<T> {
	 public static int INF = Integer.MAX_VALUE;
	 WeightedGraph<T> graph;
	 Map<Node<T>, Integer> distance;
	 
	 public BellmanFord(WeightedGraph<T> graph){
		 this.graph = graph;
		 distance = new HashMap<>();
	 }
	 
	 public void shortestDistance(Node<T> source){
		// Step 1: Initialize distances from source to all other
	    // vertices as INFINITE
		for(Node<T> vertex : graph.getVertices()){
			 if(source.equals(vertex)) distance.put(vertex, 0);
			 else distance.put(vertex, INF);
		}
		
		List<Edge<T>> edges = graph.getEdges();
		
		// Step 2: Relax all edges |V| - 1 times. A simple
        // shortest path from src to any other vertex can
        // have at-most |V| - 1 edges
		for(int i = 0; i < graph.vertexCount(); ++i){
			for(Edge<T> edge : edges){
				Node<T> u = edge.from();
				Node<T> v = edge.to();
			    int weight = edge.getWeight();
			    int path = distance.get(u) + weight;
				if(distance.get(u) != INF && path < distance.get(v)){
				    distance.put(v, path);
			}
		}
			
		// Step 3: check for negative-weight cycles.  The above
		// step guarantees shortest distances if graph doesn't
	    // contain negative weight cycle. If we get a shorter
	    //  path, then there is a cycle.
		for(Edge<T> edge : edges){ 
		    int path = distance.get(edge.from())+ edge.getWeight();;
		    if(distance.get( edge.to()) > path){
		    	System.out.println("Graph contains negative weight cycle");
		    	break;
		    }
		}
	 }		 
  }
}
