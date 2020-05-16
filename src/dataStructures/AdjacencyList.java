package dataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import AuxiliarDataStructures.IQueue;
import AuxiliarDataStructures.IStack;
import AuxiliarDataStructures.Queue;
import AuxiliarDataStructures.Stack;

public class AdjacencyList<V> implements Graph<V> {

	private List<List<List<Double>>> graph;
	private List<Vertex<V>> vertex;
	private boolean directed;
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

		if (searchIndex(vertex) == -1) {

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

		if (index != -1) {

			removed = true;

			for (int i = 0; i < this.graph.size(); i++) {
				for (int j = 0; j < this.graph.get(i).size(); j++) {

					if (this.graph.get(i).get(j).get(0) == ((double) index)) {

						this.graph.get(i).remove(j);
					}
				}
			}

			this.vertex.remove(index);

			this.size--;
		}

		return removed;
	}

	@Override
	public boolean addEdge(Vertex<V> vertex_1, Vertex<V> vertex_2) {

		boolean added = false;

		int a = searchIndex(vertex_1);
		int b = searchIndex(vertex_2);

		if (a != -1 && b != -1) {

			ArrayList<Double> temp = new ArrayList<Double>();
			temp.add((double) b);
			this.graph.get(a).add(temp);

			if (!this.isDirected()) {

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

		if (a != -1 && b != -1) {

			ArrayList<Double> temp = new ArrayList<Double>();

			temp.add((double) b);
			temp.add(weight);

			this.graph.get(a).add(temp);

			if (!this.isDirected()) {

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

		for (int i = 0; i < this.vertex.size() && !stop; i++) {

			if (this.vertex.get(i).getElement().hashCode() == hashcode) {

				index = i;
				stop = true;
			}
		}

		return index;
	}

	// REVISAR
	public double[][] floydWarshall() {

		double[][] matrixDistances = buildWeightsMatrix();

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

//  public void kruskalInMatrix(){
//	//TODO
//	//Missing fill all edges, edges ha
//    PriorityQueue<Edge> pq = new PriorityQueue<Edge>(getEdges().size(),new Edge());
//
//    //add all the edges to priority queue, //sort the edges on weights
//    for (int i = 0; i <getEdges().size() ; i++) {
//        pq.add(getEdges().get(i));
//    }
//
//    UnionFind<Vertex<V>> unionFind = new  UnionFind(getVertex());
//    //makeset
//    unionFind.makeSet();
//
//    ArrayList<Edge> mst = new ArrayList<>();
//
//    //process vertices - 1 edges
//    int index = 0;
//    while( index < vertex.size()-1){
//        Edge edge = pq.remove();
//      
//        int origin = unionFind.find(searchIndex(edge.getOrigin()));
//        int destination = unionFind.find(searchIndex(edge.getDestination()));
//
//        if(origin != destination){
//            mst.add(edge);
//            index++;
//            unionFind.union(origin,destination);
//        }
//    }
//    
//}

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
				double distanceMin = distance[frontInt] + getEdgeWeight(frontInt, posAdjacent); // beware of max double
																								// limit

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

	// The first element of path is the destination vertex and the last element is
	// the origin.
	// so you gotta do a backwards search
	public ArrayList<V> dijkstraPath(V ori, V destination) {

		ArrayList<Vertex<V>> pre = dijkstra(ori);
		ArrayList<Vertex<V>> path = new ArrayList<Vertex<V>>();
		ArrayList<V> temp = new ArrayList<V>();
		
		Vertex<V> dest = new Vertex<V>(destination);
		boolean stop = false;
		int destPos = searchIndex(dest);

		for (int i = 0; i < pre.size() && !stop; i++) {
			if (i == destPos) {
				stop = true;
			}
		}
		path.add(getVertex().get(destPos));

		Vertex<V> backwards = pre.get(destPos);

		while (backwards != null) {
			path.add(backwards);

			int indexPrev = searchIndex(backwards);

			backwards = pre.get(indexPrev);

		}
		
		for (int i = 0; i < path.size(); i++) {
			
			temp.add(path.get(i).getElement());
		}

		return temp;
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
				double distanceBetweenV = getEdgeWeight(frontInt, posAdjacent);
				if (vertexInMatter.getColor().equalsIgnoreCase(Vertex.WHITE)
						&& (distanceBetweenV < vertexInMatter.getDistance())) {
					int distanceInt = (int) distanceBetweenV; // watch out for similar distances
					vertexInMatter.setDistance(distanceInt);
					vertexInMatter.setPrior(head);
					pq = updatePQ(pq);
				}

			}

			head.setColor(Vertex.BLACK);

		}

	}

	// always has to work
	public double getEdgeWeight(int origin, int destiny) {

		double weight = Integer.MAX_VALUE;

		for (int i = 0; i < graph.get(origin).size() && weight == Integer.MAX_VALUE; i++) {

			if (destiny == graph.get(origin).get(i).get(0)) {
				weight = graph.get(origin).get(i).get(1);
			}
		}
		return weight;

	}

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

		for (int i = 0; i < this.graph.get(index).size(); i++) {

			adjacents.add((int) ((this.graph.get(index).get(i).get(0).doubleValue())));
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

	public double pathCost(V ori, V destination) {

		ArrayList<V> temp = bfsPath(ori, destination);
		double cost = 0;

		double[][] fw = floydWarshall();

		for (int i = 0; i < temp.size() - 1; i++) {

			cost += fw[searchIndex(ori)][searchIndex(destination)];
		}

		return cost;
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
	
	private int searchIndexV(Vertex<V> vertex) {

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

} // end of class
