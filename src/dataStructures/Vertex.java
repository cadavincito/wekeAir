package dataStructures;

import java.util.Comparator;

public class Vertex<E> implements Comparator<Vertex<E>>{

	public final static String BLACK = "B";
	public final static String GREY = "G";
	public final static String WHITE = "W";
	
	private E element;
	private int timeStampi;
	private int timeStampf;
	private String color;
	private int distance;
	private double weight;
	private Vertex<E> prior;
	
	/**
	 * @param element
	 * @param timeStampi
	 * @param timeStampf
	 * @param color
	 * @param distance
	 */
	public Vertex(E element) {
		
		this.element = element;
		this.timeStampi = 0;
		this.timeStampf = 0;
		this.color = WHITE;
		this.distance = -1;
		this.prior = null;
		this.weight = 0;
	}
	
	public Vertex() {
		
	}

	/**
	 * @return the element
	 */
	E getElement() {
		return element;
	}

	/**
	 * @param element the element to set
	 */
	void setElement(E element) {
		this.element = element;
	}

	/**
	 * @return the timeStampi
	 */
	int getTimeStampi() {
		return timeStampi;
	}

	/**
	 * @param timeStampi the timeStampi to set
	 */
	void setTimeStampi(int timeStampi) {
		this.timeStampi = timeStampi;
	}

	/**
	 * @return the timeStampf
	 */
	int getTimeStampf() {
		return timeStampf;
	}

	/**
	 * @param timeStampf the timeStampf to set
	 */
	void setTimeStampf(int timeStampf) {
		this.timeStampf = timeStampf;
	}

	/**
	 * @return the color
	 */
	String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the distance
	 */
	int getDistance() {
		return distance;
	}

	/**
	 * @param distance the distance to set
	 */
	void setDistance(int distance) {
		this.distance = distance;
	}
	
	/**
	 * @return the prior
	 */
	public Vertex<E> getPrior() {
		return prior;
	}
	
	/**
	 * @param prior the prior to set
	 */
	public void setPrior(Vertex<E> prior) {
		this.prior = prior;
	}
	

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public int compare(Vertex<E> o1, Vertex<E> o2) {
		if (o1.getWeight() < o2.getWeight()) 
            return -1; 
        if (o1.getWeight() > o2.getWeight()) 
            return 1; 
        return 0;
	}
	
	
	
} //end of class
