package algorithms.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import data_structures.graph.Graph;
import data_structures.graph.Node;

public class DFS<T> {
	protected Graph<T> graph;
	List<Node<T>> path;
	protected Set<Node<T>> visited;
	
	public DFS(Graph<T> graph){
		this.graph = graph;
		this.path = new ArrayList<>();
		this.visited = new HashSet<>();
		
	}
	
	public void depthFirstSearch(T vertex){
		Node<T> current = graph.getNode(vertex);
		visited.add(current);
		path.add(current);
		current.edges().forEach(edge->{
			Node<T> neighbor = edge.to();
			if(!visited.contains(neighbor)){
				depthFirstSearch(neighbor.vertex());
			}
		});
	}
	
	public void depthFirstSearchIter(T vertex){
		if (!graph.containsVertex(vertex)) {
            return;
        }
		visited.clear();
        path.clear();
		
		Stack<Node<T>> stack = new Stack<>();
        Node<T> start = graph.getNode(vertex);
        stack.push(start);
		
        while(!stack.empty()){
        	Node<T> v = stack.pop();
        	visited.add(v);
        	path.add(v);
        	v.edges().forEach(edge->{
        		Node<T> neighbor = edge.to();
        		if(!visited.contains(neighbor)){
        			stack.push(neighbor);
        		}
        	});	
        }
	}
	
	public List<Node<T>> getPathFrom(T source) {

		if (!graph.containsVertex(source)) {
            return null;
        }
		depthFirstSearch(source);
        return path;
    }
}
