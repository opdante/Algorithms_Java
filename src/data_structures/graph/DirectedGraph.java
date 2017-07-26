package data_structures.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DirectedGraph<T> implements Graph<T> {
private Map<T, Node<T>> adjacencyList;
	
	public DirectedGraph(){
		adjacencyList = new HashMap<>();
	}

	@Override
	public boolean addVertex(T vertex) {
		if(adjacencyList.containsKey(vertex)) return false;
		
		adjacencyList.put(vertex, new Node<>(vertex));
		return true;
	}

	@Override
	public boolean addEdge(T vertex1, T vertex2) {
		return addEdge(vertex1, vertex2, 0);
	}

	@Override
	public boolean addEdge(T vertex1, T vertex2, int weight) {
		if(!containsVertex(vertex1) || !containsVertex(vertex2)){
			throw new RuntimeException("Vertex does not exist");
		}
		
		// add the edge
        Node<T> node1 = getNode(vertex1);
        Node<T> node2 = getNode(vertex2);
        return node1.addEdge(node2, weight);
	}

	@Override
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

	@Override
	public boolean containsVertex(T vertex) {
		return adjacencyList.containsKey(vertex);
	}

	@Override
	public boolean removeEdge(T vertex1, T vertex2) {
		if (!containsVertex(vertex1) || !containsVertex(vertex2)) {
            return false;
        }
        return getNode(vertex1).removeEdge(getNode(vertex2)) && 
							getNode(vertex2).removeEdge(getNode(vertex1));
	}

	@Override
	public boolean containsEdge(T vertex1, T vertex2) {
		if (!containsVertex(vertex1) || !containsVertex(vertex2)) {
            return false;
        }
        return getNode(vertex1).hasEdge(getNode(vertex2)) && 
        		getNode(vertex2).hasEdge(getNode(vertex1));
	}

	@Override
	public int vertexCount() {
		return adjacencyList.keySet().size();
	}

	@Override
	public Node<T> getNode(T value) {
		return adjacencyList.get(value);
	}

	@Override
	public Set<Node<T>> getVertices() {
		return new HashSet<Node<T>>(adjacencyList.values());
	}
}
