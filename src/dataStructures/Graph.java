package dataStructures;

import java.util.ArrayList;

import model.City;

public interface Graph<V> {

	boolean addVertex(Vertex<V> vertex);
	boolean removeVertex(Vertex<V> vertex);
	boolean addEdge(Vertex<V> vertex_1, Vertex<V> vertex_2);
	boolean addEdge(Vertex<V> vertex_1, Vertex<V> vertex_2, double weight);
	double[][] floydWarshall();
	ArrayList<Vertex<V>> dijkstra(V origin);
	ArrayList<V> dijkstraPath(V v1, V v2);
	int searchIndex(V element);
	double pathCost(V v1, V v2);
	ArrayList<V> bfsPath(V v1, V v2);
	
	
}
