package dataStructures;

import java.util.Comparator;

public class Edge<E> implements Comparator<Edge<E>>{

	private Vertex<E> origin;
	private Vertex<E> destination;
	private double weight;
	
	public Edge(){
	}
	
	public Edge(Vertex<E> origin, Vertex<E> destination, double weight) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.weight = weight;
	}
	
	public Edge(Vertex<E> origin, Vertex<E> destination) {
		super();
		this.origin = origin;
		this.destination = destination;
	}

	public Vertex<E> getOrigin() {
		return origin;
	}

	public void setOrigin(Vertex<E> origin) {
		this.origin = origin;
	}

	public Vertex<E> getDestination() {
		return destination;
	}

	public void setDestination(Vertex<E> destination) {
		this.destination = destination;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public int compare(Edge<E> o1, Edge<E> o2) {
		if (o1.getWeight() < o2.getWeight()) 
            return -1; 
        if (o1.getWeight() > o2.getWeight()) 
            return 1; 
        return 0;
	}
	
	
	
	
	
} //end of class
