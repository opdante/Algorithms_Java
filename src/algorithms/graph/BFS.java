package algorithms.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import data_structures.graph.Graph;
import data_structures.graph.Node;

public class BFS<T> {
	protected Graph<T> graph;
	List<Node<T>> path;
	
	public BFS(Graph<T> graph){
		this.graph = graph;
		this.path = new ArrayList<>();
	}
	
	public void breadthFirstSearch(T vertex){
		if(!graph.containsVertex(vertex))
			return;
		
		Queue<Node<T>> queue = new LinkedList<>();
		Set<Node<T>> visited = new HashSet<>();
		Node<T> start = graph.getNode(vertex);
		queue.add(start);
		
		while(!queue.isEmpty()){
			Node<T> v = queue.poll();
			v.edges().forEach(edge->{
				Node<T> neighbor = edge.to();
				if(!visited.contains(neighbor)){
					queue.add(neighbor);
					addNodeToPath(neighbor);
				}
			});
		}
	}
	
	public void addNodeToPath(Node<T> node) {
        path.add(node);
    }
	
	public List<Node<T>> getPathFrom(T source) {
		if(!graph.containsVertex(source)) return null;
		breadthFirstSearch(source);
        return path;
    }
	
}
