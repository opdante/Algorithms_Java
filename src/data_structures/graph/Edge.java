package data_structures.graph;

public class Edge<T> {
	private Node<T> from;
	
	private Node<T> to;
	
	private int weight;

	public Edge(Node<T> from, Node<T> to, int weight) {
		this.from = from;
		this.to = to;
		this.setWeight(weight);
	}
	
	public Node<T> from(){
		return from;
	}
	
	public Node<T> to(){
		return to;
	}
	
	public boolean isBetween(Node<T> from, Node<T> to){
		return (this.from == from && this.to == to);
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}
