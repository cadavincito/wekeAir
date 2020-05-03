package model;

public class Flight {
	
	public final static double PRICE_PER_KM = 0.05;
	
	private double price;
	private double distance;
	
	private City departure;
	private City arrival;
	
	public Flight(City departure, City arrival, double distance) {
		super();
		this.departure = departure;
		this.arrival = arrival;
		this.distance = distance;
		this.price = PRICE_PER_KM*distance;
	}
	
	

	public City getDeparture() {
		return departure;
	}

	public void setDeparture(City departure) {
		this.departure = departure;
	}

	public City getArrival() {
		return arrival;
	}

	public void setArrival(City arrival) {
		this.arrival = arrival;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	


} //end of class
