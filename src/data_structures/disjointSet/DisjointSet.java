package data_structures.disjointSet;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Thabang
 * 
 * Disjoint sets functions supposed
 * - makeSet
 * - union
 * - findSet
 *
 */
public class DisjointSet<T> {
	
	private Map<T, Node> parent = new HashMap<>();
	
	class Node {
		T data;
		Node parent;
		int rank;
	}
	
	/**
	 * Create initial set with a single element
	 */
	public void makeSet(T data){
		Node node = new Node();
		node.data = data;
		node.parent = node;
		node.rank = 0;
		parent.put(data, node);
	}
	
	
	/**
	 * Create a union of two sets
	 */
	public boolean union(T set1, T set2){
		Node n1 = parent.get(set1);
		Node n2 = parent.get(set2);
		
		Node p1 = find(n1);
		Node p2 = find(n2);
		
		if(p1.data == p2.data) return false;
		
		// the node with the higher rank become parent 
		if(p1.rank >= p2.rank){
			p1.rank = (p1.rank == p2.rank) ? 
					p1.rank + 1 : p1.rank;
			p2.parent = p1;
		} else {
			p1.parent = p2;
		}
		return true;
	}
	
	/**
     * Finds the representative of a set
     */
	public T find(T data){
		return find(parent.get(data)).data;
	}
	
	private Node find(Node n){
		Node parent = n.parent;
		if(parent == n) return parent;
		
		n.parent = find(n.parent);
		return n.parent;
	}
}

