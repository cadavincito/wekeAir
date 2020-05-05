package dataStructures;

public class Edge<E> {

	private Vertex<E> origin;
	private Vertex<E> destination;
	private double weight;
	
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
	
	
	
	
	
} //end of class
