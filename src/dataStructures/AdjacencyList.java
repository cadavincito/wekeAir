package dataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.internal.runners.model.EachTestNotifier;

import AuxiliarDataStructures.IQueue;
import AuxiliarDataStructures.IStack;
import AuxiliarDataStructures.Queue;
import AuxiliarDataStructures.Stack;

public class AdjacencyList<V> implements Graph<V>{

	private List<List<List<Double>>> graph;
	private List<Vertex<V>> vertex;
	private boolean directed ;
	private int size;
	
	/**
	 * @param graph
	 * @param directed
	 * @param size
	 */
	public AdjacencyList(boolean directed) {

		graph = new ArrayList<List<List<Double>>>();
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

			this.graph.add(new ArrayList<List<Double>>());

			this.size++;
		}
		
		return added;
	}

	@Override
	public boolean removeVertex(Vertex<V> vertex) {
		
		boolean removed = false;

		int index = searchIndex(vertex);
		
		if(index != -1) {
			
			removed = true;
			
			for(int i = 0; i < this.graph.size(); i++) {
				for (int j = 0; j < this.graph.get(i).size(); j++) {
					
					if(this.graph.get(i).get(j).get(0) == ((double) index)) {
						
						this.graph.get(i).remove(j);
					}
				}
			}
			
			this.vertex.remove(index);
			
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
			temp.add((double) b);
			this.graph.get(a).add(temp);
			
			if(!this.isDirected()) {
				
				ArrayList<Double> temp2 = new ArrayList<Double>();
				temp2.add((double) a);
				this.graph.get(b).add(temp2);
			}
			
			
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

			temp.add((double) b);
			temp.add(weight);

			this.graph.get(a).add(temp);
			
			if(!this.isDirected()) {
				
				ArrayList<Double> temp2 = new ArrayList<Double>();
				temp2.add((double) a);
				temp2.add(weight);
				this.graph.get(b).add(temp2);
			}
			
			
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
	
	//REVISAR
	public double[][] floydWarshall() {
		
		double[][] matrixDistances = buildWeightsMatrix();
		
		for (int i = 0; i < matrixDistances.length; i++) {
			matrixDistances[i][i] = 0;
		}
		
		for (int i = 0; i < matrixDistances.length; i++) {
			for (int j = 0; j < matrixDistances[0].length; j++) {
				
				if (i !=j) {
					if (matrixDistances[i][j] == 0) { //ask if there can be a 0 weighted edge  between != vertexes
						matrixDistances[i][j] = Double.MAX_VALUE;
					}
				}
				
			}
		}
		
		for (int k = 0; k < vertex.size(); k++) {
			for (int i = 0; i < matrixDistances.length; i++) {
				for (int j = 0; j < matrixDistances[0].length; j++) {
					
					if (matrixDistances[i][j] > matrixDistances[i][k] + matrixDistances[k][j]) {
						matrixDistances[i][j] = matrixDistances[i][k] + matrixDistances[k][j];
					}
				
					
				}
			}
			
		}
		
		return matrixDistances;
		
	}
	
	public double[][] buildWeightsMatrix() {
		double[][] weights = new double[vertex.size()][vertex.size()];
		
		for (int i = 0; i < graph.size(); i++) {
			for (int j = 0; j < graph.get(i).size(); j++) {
				
				int y = graph.get(i).get(j).get(0).intValue();
				double value = graph.get(i).get(j).get(1);
				weights[i][y] = value;
			}
		}
		
		return weights;
	}
	
	@Override
	public ArrayList<Vertex<V>> dijkstra(V ori) {

		Vertex<V> origin = new Vertex<V>(ori);
		double[] distance = new double[vertex.size()];
		ArrayList<Vertex<V>> prior = new ArrayList<Vertex<V>>(getVertex().size());
		
		
		for (int i = 0; i < vertex.size(); i++) {
			distance[i]= Double.MAX_VALUE;
			prior.set(i, null);
			getVertex().get(i).setWeight(Double.MAX_VALUE);
		}
		
		int posOri = searchIndex(origin);
		distance[posOri] = 0;
		getVertex().get(posOri).setWeight(0);
		
		PriorityQueue<Vertex<V>> vertexes = new PriorityQueue<Vertex<V>>(getVertex()); 
		
		while (!(vertexes.isEmpty())) {
			
			Vertex<V> front = vertexes.poll();
			int frontInt = searchIndex(front);
			
			ArrayList<Integer> adjacentsInt = adjacents(frontInt);
			
			for (int i = 0; i < adjacentsInt.size(); i++) {
				int posAdjacent = adjacentsInt.get(i);
				double distanceMin = distance[frontInt] + getEdgeWeight(frontInt, posAdjacent); //beware of max double limit
				
				if (distanceMin < distance[posAdjacent]) {
					
					distance[posAdjacent] = distanceMin;
					prior.set(posAdjacent, getVertex().get(frontInt));
					getVertex().get(posAdjacent).setWeight(distanceMin);
					
				}
				
			}
			
		}
		
		return prior;

	}
	
	//The first element of path is the destination vertex and the last element is the origin.
	//so you gotta do a backwards search
	public ArrayList<Vertex<V>> findShortestPathBetweenVertexes(V ori, V destination){
		
		ArrayList<Vertex<V>> pre = dijkstra(ori);
		ArrayList<Vertex<V>> path = new ArrayList<Vertex<V>>();
		Vertex<V> dest = new Vertex<V>(destination);
		boolean stop = false;
		int destPos = searchIndex(dest);
		
		for (int i = 0; i < pre.size() && !stop; i++) {
			if (i == destPos) {
				stop = true;
			}
		}
		path.add(getVertex().get(destPos));
		
		Vertex<V>  backwards = pre.get(destPos);
		
		while (backwards != null) {
			path.add(backwards);
			
			int indexPrev = searchIndex(backwards);
			
			backwards = pre.get(indexPrev);
			
		}
		
		
		return path;
	}
	
	//always has to work
	public double getEdgeWeight(int origin, int destiny) {
		
		double weight = Integer.MAX_VALUE;
		
		
		for (int i = 0; i < graph.get(origin).size() && weight == Integer.MAX_VALUE; i++) {
			
			if (destiny == 	graph.get(origin).get(i).get(0)) {
				weight = graph.get(origin).get(i).get(1);
			}
		}
		return weight;
		
	}
	
	
	public List<Integer> bfs(Vertex<V> origin){
		
		Integer index = searchIndex(origin);
		
		ArrayList<Integer> path = new ArrayList<Integer>();

		IQueue<Integer> q = new Queue<Integer>();
		q.add(index);
		
		while(!q.isEmpty()) {
			
			index = q.poll();
			if(!contains(path,index))
				path.add(index);
			
			ArrayList<Integer> adjacents = adjacents(index);
			
			for (int i = 0; i < adjacents.size(); i++) {
				
				Integer temp = adjacents.get(i);
				
				if(!q.contains(temp) && (!contains(path,index)))
					q.add(temp);
			}
			
		}
		
		return path;
	}

	public List<Integer> dfs(Vertex<V> origin){
		
		Integer index = searchIndex(origin);
		
		ArrayList<Integer> path = new ArrayList<Integer>();

		IStack<Integer> s = new Stack<Integer>();
		s.push(index);
		
		while(!s.isEmpty()) {
			
			index = s.pop();
			if(!contains(path, index))
				path.add(index);
			
			ArrayList<Integer> adjacents = adjacents(index);
			
			for (int i = 0; i < adjacents.size(); i++) {
				
				Integer temp = adjacents.get(i);
				
				if((!s.contains(temp))&&(!contains(path, temp))) {
					s.push(temp);
					
				}
			}
			
		}
		
		return path;
	}
	
	
	
	public ArrayList<Integer> adjacents(Integer index) {
		
		Double inde = (double) index.intValue();
		
		ArrayList<Integer> adjacents = new ArrayList<Integer>();
		
		for (int i = 0; i < this.graph.size(); i++) {
			
			for (int j = 0; j < this.graph.get(i).size(); j++) {
				
				Double temp = this.graph.get(i).get(j).get(0);
				
				if( temp == inde) {
					
					if(!contains(adjacents, i)) {
						
						adjacents.add(temp.intValue());
					}
					
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
	List<List<List<Double>>> getGraph() {
		return graph;
	}


	/**
	 * @return the vertex
	 */
	List<Vertex<V>> getVertex() {
		return vertex;
	}

	
	
} //end of class
