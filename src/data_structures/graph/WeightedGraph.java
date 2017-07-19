package data_structures.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WeightedGraph<T> {
	private Map<T, Node<T>> adjacencyList;
	private boolean Undirected;
	
	public WeightedGraph(boolean Undirected) {
		adjacencyList = new HashMap<>();
        this.Undirected = Undirected;
    }
	
	public WeightedGraph() {
		adjacencyList = new HashMap<>();
        this.Undirected = false;
    }
	
	public boolean addVertex(T vertex) {
		if(adjacencyList.containsKey(vertex)) return false;
		
		adjacencyList.put(vertex, new Node<>(vertex));
		return true;
	}
	
	public boolean removeVertex(T vertex) {
		if (!adjacencyList.containsKey(vertex)) {
            return false;
        }

        // get node to be removed
        final Node<T> toRemove = getNode(vertex);

        // remove all incoming edges to node
        adjacencyList.values().forEach(node -> node.removeEdge(toRemove));

        // remove the node
        adjacencyList.remove(vertex);
        return true;
	}
	
	public boolean addEdge(T vertex1, T vertex2, int weight) {
		if(!containsVertex(vertex1) || !containsVertex(vertex2)){
			throw new RuntimeException("Vertex does not exist");
		}
		// add the edge
        Node<T> node1 = getNode(vertex1);
        Node<T> node2 = getNode(vertex2);
        if (Undirected)
        	return node1.addEdge(node2, 0) && node2.addEdge(node1, 0);
        
        return node1.addEdge(node2, 0); 
	}
	
	public boolean containsVertex(T vertex) {
		return adjacencyList.containsKey(vertex);
	}

	public boolean containsEdge(T vertex1, T vertex2) {
		if (!containsVertex(vertex1) || !containsVertex(vertex2)) {
            return false;
        }
		
		if(Undirected){
			return getNode(vertex1).hasEdge(getNode(vertex2)) && 
        		getNode(vertex2).hasEdge(getNode(vertex1));
		}
		
		return getNode(vertex1).hasEdge(getNode(vertex2));
	}
	
	public boolean removeEdge(T vertex1, T vertex2) {
		if (!containsVertex(vertex1) || !containsVertex(vertex2)) {
            return false;
        }
		if(Undirected){
			return getNode(vertex1).removeEdge(getNode(vertex2)) && 
							getNode(vertex2).removeEdge(getNode(vertex1));
		}
		
		return getNode(vertex1).removeEdge(getNode(vertex2));
	}

	/**
     * Method to get the number of vertices in the graph.
     * @return  count of vertices
     */
	public int vertexCount() {
		return adjacencyList.keySet().size();
	}
	
	public Set<Node<T>> getVertices() {
        return new HashSet(adjacencyList.keySet());
    }
	
	public List<Edge<T>> getEdges(){
		List<Edge<T>> edges=new LinkedList<>();
	    Set<Node<T>> vertices = this.getVertices();
	    for(Node<T> vertex : vertices){
	    	edges.addAll(vertex.edges());
	    }
	    return edges;
	}

	public Node<T> getNode(T value) {
		return adjacencyList.get(value);
	}
}
