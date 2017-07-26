package algorithms.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

import data_structures.graph.DirectedGraph;
import data_structures.graph.Graph;
import data_structures.graph.Node;

public class TopologicalSort<T> {
	
	public Deque<Node<T>> topologicalSort(Graph<T> graph){
		Deque<Node<T>> stack = new ArrayDeque<>();
		Set<Node<T>> visited = new HashSet<>();
		graph.getVertices().forEach(vertex->{
			if(!visited.contains(vertex)){
				topologicalSortUtil(vertex, stack, visited);
			}
		});
		
		return stack;
	}
	
	private void topologicalSortUtil(Node<T> vertex, 
			Deque<Node<T>> stack, Set<Node<T>> visited){
		visited.add(vertex);
		vertex.edges().forEach(edge->{
			Node<T> adjacent = edge.to();
			if(!visited.contains(adjacent)){
				topologicalSortUtil(adjacent, stack, visited);
			}
			
		});
		stack.offerFirst(vertex);
	}
	
	public static void main(String args[]){
		Graph<Integer> graph = new DirectedGraph<>();
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addVertex(5);
		graph.addVertex(6);
		graph.addVertex(8);
		graph.addVertex(11);
		graph.addEdge(1, 3);
		graph.addEdge(1, 2);
		graph.addEdge(3, 4);
		graph.addEdge(5, 6);
		graph.addEdge(6, 3);
		graph.addEdge(3, 8);
		graph.addEdge(8, 11);
		TopologicalSort<Integer> sort = new TopologicalSort<>();
		Deque<Node<Integer>> res = sort.topologicalSort(graph);
		
		while(!res.isEmpty()){
			System.out.println(res.poll());
		}
		
	}
}
