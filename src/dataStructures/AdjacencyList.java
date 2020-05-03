package dataStructures;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyList<V> implements Graph<V>{

	private List<List<Double>> graph;
	private List<Vertex<V>> vertex;
	private boolean directed ;
	private int size;
	
	/**
	 * @param graph
	 * @param directed
	 * @param size
	 */
	public AdjacencyList(boolean directed) {

		graph = new ArrayList<List<Double>>();
		this.vertex = new ArrayList<Vertex<V>>();
		this.directed = directed;
		this.size = 0;
	}


	@Override
	public boolean addVertex(Vertex<V> vertex) {
		
		boolean added = false;
		
		if(searchIndex(vertex) == -1) {
			
			this.vertex.add(vertex);
			
			added = true;
			
			this.size++;
		}
		
		return added;
	}

	@Override
	public boolean removeVertex(Vertex<V> vertex) {
		boolean removed = false;

		int a = searchIndex(vertex);
		
		if(a != -1) {
			
			this.vertex.remove(a);
			
			removed = true;
			
			for (int i = 0; i < this.graph.size(); i++) {
				
				if((this.graph.get(i).get(0).compareTo((double) a) == 0) || this.graph.get(i).get(1).compareTo((double) a) == 0) {
					this.graph.remove(i);
				}
			}
			
			this.size --;
		}
		
		return removed;
	}

	@Override
	public boolean addEdge(Vertex<V> vertex_1, Vertex<V> vertex_2) {
		
		boolean added = false;
		
		int a = searchIndex(vertex_1);
		int b = searchIndex(vertex_2);
				
		if(a != -1 && b != -1) {
			
			ArrayList<Double> temp = new ArrayList<Double>();

			temp.add((double) a);
			temp.add((double) b);
			
			this.graph.add(temp);
			
			added = true;

		}
		
		return added;
	}

	@Override
	public boolean addEdge(Vertex<V> vertex_1, Vertex<V> vertex_2, double weight) {
		
		boolean added = false;
		
		int a = searchIndex(vertex_1);
		int b = searchIndex(vertex_2);
				
		if(a != -1 && b != -1) {
			
			ArrayList<Double> temp = new ArrayList<Double>();

			temp.add((double) a);
			temp.add((double) b);
			temp.add(weight);
			
			this.graph.add(temp);
			
			added = true;

		}
		
		return added;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public boolean isDirected() {
		return directed;
	}


	public int searchIndex(Vertex<V> vertex) {
		
		int index = -1;
		
		int hashcode = vertex.getElement().hashCode();
		
		boolean stop = false;
		
		for (int i = 0; i < this.vertex.size() && !stop ; i++) {
			
			if(this.vertex.get(i).getElement().hashCode() == hashcode) {
				
				index = i;
				stop = true;
			}
		}
		
		return index;
	}
	
	/**
	 * @return the graph
	 */
	List<List<Double>> getGraph() {
		return graph;
	}


	/**
	 * @return the vertex
	 */
	List<Vertex<V>> getVertex() {
		return vertex;
	}
	
	
	
}
