package dataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import exceptions.InvalidBaseNumber;

public class AdjacencyMatrix<V> implements Graph<V> {

	
	public final static int BASE = 30;
	
	private int[][] graph;
	private double[][] weights;
	private List<Vertex<V>> vertex;
	private boolean directed ;
	private int size;
	
	public AdjacencyMatrix(boolean directed, int m) throws InvalidBaseNumber {
		
		if(m<=0)
			throw new InvalidBaseNumber("The given base number to initizalize the mathix must be > 0.");
		this.graph = new int[BASE][BASE];
		this.weights = new double[BASE][BASE];
		
		this.vertex = new ArrayList<Vertex<V>>();
		this.directed = directed;
		this.size = 0;
		
	}
	
	public AdjacencyMatrix(boolean directed) {
		
		this.graph = new int[BASE][BASE];
		this.weights = new double[BASE][BASE];
		
		for (int i = 0; i < graph.length; i++) {
			Arrays.fill(graph[i], 0);
		}
		
		this.vertex = new ArrayList<Vertex<V>>();
		this.directed = directed;
		this.size = 0;
		
	}
	
	@Override
	public boolean addVertex(Vertex<V> vertex) {
		
		boolean added = false;
		
		if(!this.vertex.contains(vertex)) {
			
			this.size++;
			
			this.vertex.add(vertex);
			if(this.vertex.size() > graph.length)
				extendMatrix();
			
			added = true;
		}
		
		return added;
	}

	public void extendMatrix() {
		
		int tempLength = this.graph.length;
		int temp[][] = new int[2*tempLength][2*tempLength];
		
		for (int i = 0; i < this.graph.length; i++) {
			for (int j = 0; j < this.graph[i].length; j++) {
				
				temp[i][j] = this.graph[i][j];
			}
		}
		
		this.graph = temp;
		
	}
	
	@Override
	public boolean removeVertex(Vertex<V> vertex) {
		
	
		int index = this.vertex.indexOf(vertex);
		int temp[][] = new int[this.graph.length-1][this.graph.length-1];
		
		if(index >= 0 ) {

			
			for (int i = 0; i < temp.length; i++) {
				for (int j = 0; j < temp.length; j++) {
					
					if(i < index && j < index) 
						temp[i][j] = this.graph[i][j];
						

					if(i >= index) {
						
						if(j >= index)
							temp[i][j] = this.graph[i+1][j+1];
						else
							temp[i][j] = this.graph[i+1][j];
					}
					if(j >= index) {
						
						if(i >= index)
							temp[i][j] = this.graph[i+1][j+1];
						else
							temp[i][j] = this.graph[i][j+1];
					}
				}
			}
			
			this.size--;
		}
		
		return this.vertex.remove(vertex);
	}

	@Override
	public boolean addEdge(Vertex<V> vertex_1, Vertex<V> vertex_2) {
		
		int a = this.vertex.indexOf(vertex_1);
		int b = this.vertex.indexOf(vertex_2);
		
		
		if(a != -1 && b != -1) {
			if(this.directed)
				this.graph[a][b] = 1;
			else {
				this.graph[a][b] = 1;
				this.graph[b][a] = 1;
			}
			return true;
		}
		else
			return false;
		
	}

	@Override
	public boolean addEdge(Vertex<V> vertex_1, Vertex<V> vertex_2, double weight) {
		
		int a = this.vertex.indexOf(vertex_1);
		int b = this.vertex.indexOf(vertex_2);
		
		if(a != -1 && b != -1) {
			if(this.directed) {
				
				this.graph[a][b] = 1;
				this.weights[a][b] = weight;
		
			}
			else {
				this.graph[a][b] = 1;
				this.graph[b][a] = 1;
				
				this.weights[a][b] = weight;
				this.weights[b][a] = weight;
			}
			return true;
		}
		else
			return false;
	}
	
	public int searchIndex(Vertex<V> vertex) {
		
		int index = -1;
		
		return index;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public List<Vertex<V>> getVertex(){
		return this.vertex;
	}

}
