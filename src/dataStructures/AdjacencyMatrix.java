package dataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import AuxiliarDataStructures.IQueue;
import AuxiliarDataStructures.Queue;
import exceptions.InvalidBaseNumber;

public class AdjacencyMatrix<V> implements Graph<V> {

	
	public final static int BASE = 30;
	public final static double GROWTHFACTOR = 1.5;
	
	private int[][] graph;
	private double[][] weights;
	private List<Vertex<V>> vertex;
	private boolean directed ;
	private int size;
	
	public AdjacencyMatrix(boolean directed, int m) throws InvalidBaseNumber {
		
		if(m<=0)
			throw new InvalidBaseNumber("The given base number to initizalize the mathix must be > 0.");
		this.graph = new int[m][m];
		this.weights = new double[m][m];
		
		for (int i = 0; i < graph.length; i++) {
			Arrays.fill(graph[i], 0);
		}
		
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
		
		if(searchIndex(vertex) == -1) {
			
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
		double newLength = tempLength*GROWTHFACTOR;
		int tLength = (int) newLength;
		
		if (tempLength==1) {
			tLength = 2;
		}
		
		int temp[][] = new int[tLength][tLength];
		
		for (int i = 0; i < this.graph.length; i++) {
			for (int j = 0; j < this.graph[i].length; j++) {
				
				temp[i][j] = this.graph[i][j];
			}
		}
		
		this.graph = temp;
		
	}
	
	@Override
	public boolean removeVertex(Vertex<V> vertex) {
		
		boolean removed = false;
		int index = searchIndex(vertex);
		int temp[][] = new int[this.graph.length-1][this.graph.length-1];
		
		if(index >= 0 ) {

			removed = true;
			this.vertex.remove(index);
			
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
			
			this.graph = temp;
			
			this.size--;
		}
		
		return removed;
	}

	@Override
	public boolean addEdge(Vertex<V> vertex_1, Vertex<V> vertex_2) {
		
		int a = searchIndex(vertex_1);
		int b = searchIndex(vertex_2);
		
		
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
		
		int a = searchIndex(vertex_1);
		int b = searchIndex(vertex_2);
		
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
		int hashcode = vertex.getElement().hashCode();
		boolean stop = false;
		
		for (int i = 0; i < this.vertex.size() && !stop; i++) {
			
			if(this.vertex.get(i).getElement().hashCode() == hashcode) {
				
				index = i;
				
				stop = true;
			}
		}
		
		return index;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public List<Vertex<V>> getVertex(){
		return this.vertex;
	}
	
	public int [][] getGraph(){
		return this.graph;
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
		
		ArrayList<Integer> adjacents = new ArrayList<Integer>();
		
		for (int i = 0; i < this.vertex.size(); i++) {
			
			if(this.graph[index][i] >= 1) {
				if(!contains(adjacents,i))
					adjacents.add(i);
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

} //end of class
