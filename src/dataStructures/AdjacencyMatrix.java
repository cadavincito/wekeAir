package dataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import AuxiliarDataStructures.IQueue;
import AuxiliarDataStructures.IStack;
import AuxiliarDataStructures.Queue;
import AuxiliarDataStructures.Stack;
import AuxiliarDataStructures.UnionFind;
import exceptions.InvalidBaseNumber;
import model.City;

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

// IGNOREN ESTO PERO NO LO BORREN
//	public class Main(){
//	    
//	    public static void main(String[] args){
//	        
//	    }          
//	    
//	    public IGraph prim(IGraph<Integer> g, int vertex){
//	        IGraph<Integer> mst = new Graph<>();
//	        mst.addVertex(vertex);
//	        PriorityQueue<IEdge<Integer>> pq = new PriorityQueue<>();
//	        List<Integer> adjVertex = g.getAdjacents(vertex);
//	        for(Integer v:adjVertex){
//	            IEdge<Integer> e = new Edge<>(vertex, v, g.getWeight(vertex,v));
//	            pq.add(e);
//	        }
//	        int edgesAdded=0;
//	        while(edgesAdded<g.size()-1){
//	            IEdge<Integer> e = pq.poll();
//	            Integer newVertex = e.getEnd();
//	            if(!g.existVertex(newVertex)){
//	                mst.addVertex(newVertex);
//	                mst.addEdge(e.getStart(),e.getEnd(),e.getWeight());
//	                edgesAdded++;
//	                adjVertex = g.getAdjacents(newVertex);
//	                for(Integer v:adjVertex){
//	                    IEdge<Integer> e = new Edge<>(newVertex, v, g.getWeight(vertex,v));
//	                    pq.add(e);
//	                }
//	            }
//	        }
//	        
//	        return mst;
//	    }
//	    
//	}//end of class
	
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
	
	
	
	public int[][] getGraph() {
		return graph;
	}

	public void setGraph(int[][] graph) {
		this.graph = graph;
	}

	public double[][] getWeights() {
		return weights;
	}

	public void setWeights(double[][] weights) {
		this.weights = weights;
	}

	public boolean isDirected() {
		return directed;
	}

	public void setDirected(boolean directed) {
		this.directed = directed;
	}

	public void setVertex(List<Vertex<V>> vertex) {
		this.vertex = vertex;
	}

	public void setSize(int size) {
		this.size = size;
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
				double distanceMin = distance[frontInt] + weights[frontInt][posAdjacent]; //beware of max double limit
				
				if (distanceMin < distance[posAdjacent]) {
					
					distance[posAdjacent] = distanceMin;
					prior.set(posAdjacent, getVertex().get(frontInt));
					getVertex().get(posAdjacent).setWeight(distanceMin);
					
				}
				
			}
			
		}
		
		return prior;

	}

	
	@Override
	public double[][] floydWarshall() {
		double[][] matrixDistances = getWeights();
		
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
	
	
	public void prim(Vertex<V> origin) {
		
		for (int i = 0; i < vertex.size(); i++) {
			vertex.get(i).setColor(Vertex.WHITE);
			vertex.get(i).setDistance(-1);
			vertex.get(i).setPrior(null);
		}
		
		int foundOriginIndex = searchIndex(origin);
		
		origin = null;
		
		if (foundOriginIndex != -1) {
			origin = vertex.get(foundOriginIndex); 
		}
		//TODO
		
		
		
	}
	
//    public  <E> void kruskalInMatrix(){
//    	//TODO
//    	//Missing fill all edges
//        PriorityQueue<Edge> pq = new PriorityQueue<Edge>(allEdges.size(), Comparator.comparingInt(o -> o.weight));
//
//        //add all the edges to priority queue, //sort the edges on weights
//        for (int i = 0; i <allEdges.size() ; i++) {
//            pq.add(allEdges.get(i));
//        }
//
//        UnionFind<Vertex<E>> unionFind = new  UnionFind<Vertex<E>>(getVertex());
//        //makeset
//        unionFind.makeSet();
//
//        ArrayList<Edge> mst = new ArrayList<>();
//
//        //process vertices - 1 edges
//        int index = 0;
//        while( index < vertex.size()-1){
//            Edge edge = pq.remove();
//          
//            int origin = unionFind.find(searchIndex(edge.getOrigin()));
//            int destination = unionFind.find(searchIndex(edge.getDestination()));
//
//            if(origin != destination){
//                mst.add(edge);
//                index++;
//                unionFind.union(origin,destination);
//            }
//        }
//        
//    }
	
	
	
	public List<Integer> bfs(Vertex<V> origin){
		
		Integer index = searchIndex(origin);
		
		ArrayList<Integer> path = new ArrayList<Integer>();

		IQueue<Integer> q = new Queue<Integer>();
		q.add(index);
		
		while(!q.isEmpty()) {
			
			index = q.poll();
			if(!contains(path, index))
				path.add(index);
			
			ArrayList<Integer> adjacents = adjacents(index);
			
			for (int i = 0; i < adjacents.size(); i++) {
				
				Integer temp = adjacents.get(i);
				
				if((!q.contains(temp))&&(!contains(path, temp))) {
					q.add(temp);
					
				}
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
		
		ArrayList<Integer> adjacents = new ArrayList<Integer>();
		
		for (int i = 0; i < this.vertex.size(); i++) {
			
			if(this.graph[index][i] >= 1) {
				if(!contains(adjacents,i)) {
					
					if(this.vertex.get(i).getPrior() != null) 
						this.vertex.get(i).setPrior(this.vertex.get(index));
					
					
					adjacents.add(i);
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

	public ArrayList<V> bfsPath(V vertex_1, V vertex_2) {
		
		List<Integer> path = this.bfs(new Vertex<V>(vertex_1));
		
		ArrayList<V> ans = new ArrayList<V>();
		
		int itemp = searchIndex(new Vertex<V>(vertex_2));
		
		if(itemp != -1) {
			
			Vertex<V> temp = this.vertex.get(itemp);
			ans.add(temp.getElement());
			
			boolean stop = false;
			while(temp != null && !stop) {
				
				System.out.println(temp.getElement().toString());
				
				temp = temp.getPrior();
				
				if(temp != null) {
					ans.add(temp.getElement());
					if(temp.getElement().hashCode() == vertex_1.hashCode())
						stop = true;
				}
			}
			
			
		}
		
		return ans;
	}

	
	
} //end of class
