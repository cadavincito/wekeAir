package dataStructures;

import java.util.ArrayList;
import java.util.List;

import AuxiliarDataStructures.IQueue;
import AuxiliarDataStructures.Queue;

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
	
	
	public List<Integer> bfs(Vertex<V> origin){
		
		Integer index = searchIndex(origin);
		
		ArrayList<Integer> path = new ArrayList<Integer>();

		IQueue<Integer> q = new Queue<Integer>();
		q.add(index);
		
		while(q.size() > 0) {
			
			index = q.poll();
			if(!q.contains(index))
				path.add(index);
			
			ArrayList<Integer> adjacents = adjacents(index);
			
			for (int i = 0; i < adjacents.size(); i++) {
				
				Integer temp = adjacents.get(i);
				
				if(!q.contains(temp))
					q.add(temp);
			}
			
		}
		
		return path;
	}

	private ArrayList<Integer> adjacents(Integer index) {
		
		Double inde = (double) index.intValue();
		
		ArrayList<Integer> adjacents = new ArrayList<Integer>();
		
		for (int i = 0; i < this.vertex.size(); i++) {
			
			List<Double> temp = this.graph.get(i);
			
			if(this.directed == true) {
				
				if(temp.get(0) == inde) {
					
					Integer element = (int) temp.get(1).doubleValue();
					
					if(!contains(adjacents, element))
						adjacents.add(element);
					
				}
			}
			else {
				
				if(temp.get(0) == inde) {
					
					Integer element = (int) temp.get(1).doubleValue();
					
					if(!contains(adjacents, element))
						adjacents.add(element);
				}
				
				if(temp.get(1) == inde) {
					
					Integer element = (int) temp.get(0).doubleValue();
					
					if(!contains(adjacents, element))
						adjacents.add(element);
				}
				
			}
				
		}
		
		return adjacents;
	}
	
	public boolean contains (ArrayList<Integer> a, Integer b) {
		
		boolean contains = false;
		boolean stop = false;
		
		for (int i = 0; i < a.size() && !stop; i++) {
			if(a.get(i) == b) {
				
				contains = true;
				stop = true;
			}
		}
		
		return contains;
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
