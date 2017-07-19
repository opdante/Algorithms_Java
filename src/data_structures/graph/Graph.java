package data_structures.graph;

public interface Graph<T> {
	public boolean addVertex(T vertex);
	public boolean addEdge(T vertex1, T vertex2);
	public boolean addEdge(T vertex1, T vertex2, int weight);
	public boolean removeVertex(T vertex);
	public boolean containsVertex(T vertex);
	public boolean removeEdge(T vertex1, T vertex2);
	public boolean containsEdge(T vertex1, T vertex2);
	public int vertexCount();
	Node<T> getNode(T value);
	
}
