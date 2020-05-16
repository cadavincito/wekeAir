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
	private boolean directed;
	private int size;
	private List<Edge<V>> edges; //every edge here is considered as NOT DIRECTED so its the same edge for a-b as b-a

	public AdjacencyMatrix(boolean directed, int m) throws InvalidBaseNumber {

		if (m <= 0)
			throw new InvalidBaseNumber("The given base number to initizalize the mathix must be > 0.");
		this.graph = new int[m][m];
		this.weights = new double[m][m];

		for (int i = 0; i < graph.length; i++) {
			Arrays.fill(graph[i], 0);
		}

		this.vertex = new ArrayList<Vertex<V>>();
		this.directed = directed;
		this.size = 0;
		this.edges = new ArrayList<Edge<V>>();

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

	public List<Edge<V>> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge<V>> edges) {
		this.edges = edges;
	}

	@Override
	public boolean addVertex(Vertex<V> vertex) {

		boolean added = false;

		if (searchIndex(vertex) == -1) {

			this.size++;

			this.vertex.add(vertex);
			if (this.vertex.size() > graph.length)
				extendMatrix();

			added = true;
		}

		return added;
	}

	public void extendMatrix() {

		int tempLength = this.graph.length;
		double newLength = tempLength * GROWTHFACTOR;
		int tLength = (int) newLength;

		if (tempLength == 1) {
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
		int temp[][] = new int[this.graph.length - 1][this.graph.length - 1];

		if (index >= 0) {

			removed = true;
			this.vertex.remove(index);

			for (int i = 0; i < temp.length; i++) {
				for (int j = 0; j < temp.length; j++) {

					if (i < index && j < index)
						temp[i][j] = this.graph[i][j];

					if (i >= index) {

						if (j >= index)
							temp[i][j] = this.graph[i + 1][j + 1];
						else
							temp[i][j] = this.graph[i + 1][j];
					}
					if (j >= index) {

						if (i >= index)
							temp[i][j] = this.graph[i + 1][j + 1];
						else
							temp[i][j] = this.graph[i][j + 1];
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

		if (a != -1 && b != -1) {
			if (this.directed)
				this.graph[a][b] = 1;
			else {
				this.graph[a][b] = 1;
				this.graph[b][a] = 1;
			}
			return true;
		} else
			return false;

	}
	//MISSING ADD EDGE TO EDGE LIST
	@Override
	public boolean addEdge(Vertex<V> vertex_1, Vertex<V> vertex_2, double weight) {

		int a = searchIndex(vertex_1);
		int b = searchIndex(vertex_2);

		if (a != -1 && b != -1) {
			if (this.directed) {

				this.graph[a][b] = 1;
				this.weights[a][b] = weight;

			} else {
				this.graph[a][b] = 1;
				this.graph[b][a] = 1;

				this.weights[a][b] = weight;
				this.weights[b][a] = weight;
			}
			return true;
		} else
			return false;
	}

	public int searchIndex(Vertex<V> vertex) {

		int index = -1;
		int hashcode = vertex.getElement().hashCode();
		boolean stop = false;

		for (int i = 0; i < this.vertex.size() && !stop; i++) {

			if (this.vertex.get(i).getElement().hashCode() == hashcode) {

				index = i;

				stop = true;
			}
		}

		return index;
	}

	public int searchIndex(V vertex) {

		int index = -1;
		int hashcode = vertex.hashCode();
		boolean stop = false;

		for (int i = 0; i < this.vertex.size() && !stop; i++) {

			if (this.vertex.get(i).getElement().hashCode() == hashcode) {

				index = i;

				stop = true;
			}
		}

		return index;
	}
	
	public int getSize() {
		return this.size;
	}

	public List<Vertex<V>> getVertex() {
		return this.vertex;
	}

	// The first element of path is the destination vertex and the last element is
	// the origin.
	// so you gotta do a backwards search
	public ArrayList<V> dijkstraPath(V ori, V destination) {

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

		if (destPos != -1) {
			path.add(getVertex().get(destPos));

			Vertex<V> backwards = pre.get(destPos);

			while (backwards != null) {
				path.add(backwards);

				int indexPrev = searchIndex(backwards);

				backwards = pre.get(indexPrev);

			}
		}
		ArrayList<V> temp = new ArrayList<V>();

		for (int i = path.size() - 1; i >= 0; i--) {

			temp.add(path.get(i).getElement());
		}

		return temp;
	}

	@Override
	public ArrayList<Vertex<V>> dijkstra(V ori) {

		Vertex<V> origin = new Vertex<V>(ori);
		double[] distance = new double[getVertex().size()];
		ArrayList<Vertex<V>> prior = new ArrayList<Vertex<V>>();

		PriorityQueue<Vertex<V>> vertexes = new PriorityQueue<Vertex<V>>(getVertex().size(), new Vertex<V>());

		for (int i = 0; i < getVertex().size(); i++) {
			distance[i] = Double.MAX_VALUE;
			prior.add(null);
			getVertex().get(i).setWeight(Double.MAX_VALUE);
		}

		int posOri = searchIndex(origin);
		distance[posOri] = 0;
		getVertex().get(posOri).setWeight(0);

		for (int i = 0; i < getVertex().size(); i++) {
			vertexes.add(getVertex().get(i));
		}

		while (!(vertexes.isEmpty())) {

			Vertex<V> front = vertexes.poll();
			int frontInt = searchIndex(front);

			ArrayList<Integer> adjacentsInt = adjacents(frontInt);

			for (int i = 0; i < adjacentsInt.size(); i++) {
				int posAdjacent = adjacentsInt.get(i);
				double distanceMin = distance[frontInt] + weights[frontInt][posAdjacent]; // beware of max double limit

				if (distanceMin < distance[posAdjacent]) {

					distance[posAdjacent] = distanceMin;
					prior.set(posAdjacent, getVertex().get(frontInt));
					getVertex().get(posAdjacent).setWeight(distanceMin);
					vertexes = updatePQ(vertexes);

				}

			}

		}

		return prior;

	}

	public PriorityQueue<Vertex<V>> updatePQ(PriorityQueue<Vertex<V>> vertexes) {

		ArrayList<Vertex<V>> temp = new ArrayList<Vertex<V>>();

		while (!(vertexes.isEmpty())) {
			temp.add(vertexes.poll());
		}

		for (int i = 0; i < temp.size(); i++) {
			vertexes.add(temp.get(i));
		}

		return vertexes;

	}

	@Override
	public double[][] floydWarshall() {
		double[][] matrixDistances = getWeights();

		for (int i = 0; i < matrixDistances.length; i++) {
			matrixDistances[i][i] = 0;
		}

		for (int i = 0; i < matrixDistances.length; i++) {
			for (int j = 0; j < matrixDistances[0].length; j++) {

				if (i != j) {
					if (matrixDistances[i][j] == 0) { // ask if there can be a 0 weighted edge between != vertexes
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

	// This a predecesor list, where every position of ArrayList pre is the
	// predecesor of the vertex of the index
	public ArrayList<Vertex<V>> buildMSTPrim(V ori) {
		prim(new Vertex<V>(ori));

		ArrayList<Vertex<V>> pre = new ArrayList<Vertex<V>>(getVertex().size());

		for (int i = 0; i < getVertex().size(); i++) {
			pre.add(getVertex().get(i).getPrior());
		}

		return pre;
	}

	// check
	public void prim(Vertex<V> origin) {

		for (int i = 0; i < vertex.size(); i++) {
			vertex.get(i).setColor(Vertex.WHITE);
			vertex.get(i).setDistance(Integer.MAX_VALUE);
			vertex.get(i).setPrior(null);
		}

		int foundOriginIndex = searchIndex(origin);

		getVertex().get(foundOriginIndex).setDistance(0);

		PriorityQueue<Vertex<V>> pq = new PriorityQueue<Vertex<V>>(getVertex().size(), new Vertex<V>());

		for (int i = 0; i < getVertex().size(); i++) {
			pq.add(getVertex().get(i));
		}

		while (!(pq.isEmpty())) {

			Vertex<V> head = pq.poll();

			int frontInt = searchIndex(head);

			ArrayList<Integer> adjacentsInt = adjacents(frontInt);

			for (int i = 0; i < adjacentsInt.size(); i++) {

				int posAdjacent = adjacentsInt.get(i);
				Vertex<V> vertexInMatter = getVertex().get(posAdjacent);
				if (vertexInMatter.getColor().equalsIgnoreCase(Vertex.WHITE)
						&& (weights[frontInt][posAdjacent] < vertexInMatter.getDistance())) {
					int distanceInt = (int) weights[frontInt][posAdjacent]; // watch out for similar distances
					vertexInMatter.setDistance(distanceInt);
					vertexInMatter.setPrior(head);
					pq = updatePQ(pq);
				}

			}

			head.setColor(Vertex.BLACK);

		}

	}

//    public void kruskalInMatrix(){
//    	//TODO
//    	//Missing fill all edges, edges ha
//        PriorityQueue<Edge> pq = new PriorityQueue<Edge>(getEdges().size(),new Edge());
//
//        //add all the edges to priority queue, //sort the edges on weights
//        for (int i = 0; i <getEdges().size() ; i++) {
//            pq.add(getEdges().get(i));
//        }
//
//        UnionFind<Vertex<V>> unionFind = new  UnionFind(getVertex());
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

	public ArrayList<Vertex<V>> bfs(Vertex<V> origin) {

		Integer index = searchIndex(origin);

		ArrayList<Vertex<V>> path = new ArrayList<Vertex<V>>();
		ArrayList<Vertex<V>> priors = new ArrayList<Vertex<V>>();
		
		for (int i = 0; i < this.vertex.size(); i++) {
			priors.add(null);
		}
		
		IQueue<Integer> q = new Queue<Integer>();
		q.add(index);

		while (!q.isEmpty()) {

			index = q.poll();
			if (!containsV(path, index)) {
				path.add(this.vertex.get(index));
				
				
			}
			ArrayList<Integer> adjacents = adjacents(index);

			for (int i = 0; i < adjacents.size(); i++) {

				Integer temp = adjacents.get(i);

				if ((!q.contains(temp)) && (!containsV(path, temp))) {
					q.add(temp);
					
					priors.set(adjacents.get(i), this.vertex.get(index));
				}
			}

		}

		return priors;
	}

	public List<Integer> dfs(Vertex<V> origin) {

		Integer index = searchIndex(origin);

		ArrayList<Integer> path = new ArrayList<Integer>();

		IStack<Integer> s = new Stack<Integer>();
		s.push(index);

		while (!s.isEmpty()) {

			index = s.pop();
			if (!contains(path, index))
				path.add(index);

			ArrayList<Integer> adjacents = adjacents(index);

			for (int i = 0; i < adjacents.size(); i++) {

				Integer temp = adjacents.get(i);

				if ((!s.contains(temp)) && (!contains(path, temp))) {
					s.push(temp);

				}
			}

		}

		return path;
	}

	public ArrayList<Integer> adjacents(Integer index) {

		ArrayList<Integer> adjacents = new ArrayList<Integer>();

		for (int i = 0; i < this.vertex.size(); i++) {

			if (this.graph[index][i] >= 1) {
				if (!contains(adjacents, i)) {

					if (this.vertex.get(i).getPrior() != null)
						this.vertex.get(i).setPrior(this.vertex.get(index));

					adjacents.add(i);
				}
			}
		}

		return adjacents;
	}

	public boolean contains(ArrayList<Integer> a, Integer b) {

		boolean contains = false;
		boolean stop = false;

		for (int i = 0; i < a.size() && !stop; i++) {
			if (a.get(i) == b) {

				contains = true;
				stop = true;
			}
		}

		return contains;
	}

	public boolean containsV(ArrayList<Vertex<V>> a, Integer b) {

		boolean contains = false;
		boolean stop = false;

		for (int i = 0; i < a.size() && !stop; i++) {
			if (searchIndex(a.get(i)) == b) {

				contains = true;
				stop = true;
			}
		}

		return contains;
	}

	public ArrayList<V> bfsPath(V ori, V destination) {

		ArrayList<Vertex<V>> pre = bfs(new Vertex(ori));
		ArrayList<Vertex<V>> path = new ArrayList<Vertex<V>>();
		Vertex<V> dest = new Vertex<V>(destination);
		boolean stop = false;
		int destPos = searchIndex(dest);

		for (int i = 0; i < pre.size() && !stop; i++) {
			if (i == destPos) {
				stop = true;
			}
		}

		if (destPos != -1) {
			path.add(getVertex().get(destPos));

			Vertex<V> backwards = pre.get(destPos);

			while (backwards != null) {
				
				path.add(backwards);

				int indexPrev = searchIndex(backwards);

				backwards = pre.get(indexPrev);

			}
		}
		ArrayList<V> temp = new ArrayList<V>();

		for (int i = path.size() - 1; i >= 0; i--) {

			temp.add(path.get(i).getElement());
		}

		return temp;
	}

} // end of class
