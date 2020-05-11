package dataStructures;

import java.util.ArrayList;

public interface Graph<V> {

	boolean addVertex(Vertex<V> vertex);
	boolean removeVertex(Vertex<V> vertex);
	boolean addEdge(Vertex<V> vertex_1, Vertex<V> vertex_2);
	boolean addEdge(Vertex<V> vertex_1, Vertex<V> vertex_2, double weight);
	double[][] floydWarshall();
	ArrayList<Vertex<V>> dijkstra(V origin);
	
	
}
