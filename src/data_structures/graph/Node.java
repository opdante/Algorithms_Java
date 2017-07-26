package data_structures.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Node<T> implements Comparable<Node<T>>{
	private T vertex;
	private List<Edge<T>> edges;
	private Node<T> parent;
	
	public Node(T vertex){
		this.vertex = vertex;
		this.edges = new ArrayList<>();
	}
	
	
	public T vertex() {
        return vertex;
    }
	
	public boolean addEdge(Node<T> node, int weight){
		if(hasEdge(node)) return false;
		
		Edge<T> newEdge = new Edge<>(this, node, weight);
		return edges.add(newEdge);
		
	}
	
	public boolean removeEdge(Node<T> node){
		Optional<Edge<T>> optional = findEdge(node);
		if(optional.isPresent()){
			return edges.remove(optional.get());
		}
	    return false;
	}
	
	public List<Edge<T>> edges() {
        return edges;
    }
	
	public int getEdgeCount() {
        return edges.size();
    }
	
	public Node<T> parent() {
        return parent;
    }
    
    public void setParent(Node<T> parent) {
        this.parent = parent;
    }
	
    public boolean hasEdge(Node<T> node) {
        return findEdge(node).isPresent();
    }
    
	private Optional<Edge<T>> findEdge(Node<T> node) {
        return edges.stream()
                .filter(edge -> edge.isBetween(this, node))
                .findFirst();
    }
	
	@Override
	public String toString(){
		return "Vertex : " + vertex;
	}
	
	@Override
	public boolean equals(Object o){
		if(o == null || this.getClass() != o.getClass()) return false;
		if(this == o) return true;
		 
		return vertex.equals(((Node<T>) o).vertex);
		
	}

	@Override
	public int compareTo(Node<T> o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
