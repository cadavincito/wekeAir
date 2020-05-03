package dataStructures;

public interface Graph<V> {

	boolean addVertex(Vertex<V> vertex);
	boolean removeVertex(Vertex<V> vertex);
	boolean addEdge(Vertex<V> vertex_1, Vertex<V> vertex_2);
	boolean addEdge(Vertex<V> vertex_1, Vertex<V> vertex_2, double weight);
	
	
}
