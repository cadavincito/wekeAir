package model;

public class Flight {

	private double price;
	private int fast;

	private City departure;
	private City arrival;

	public Flight(City departure, City arrival, int fast) {
		super();
		this.departure = departure;
		this.arrival = arrival;
		this.fast = fast;
	}

	/**
	 * @return the price
	 */
	double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the fast
	 */
	int isFast() {
		return fast;
	}

	/**
	 * @param fast the fast to set
	 */
	void setFast(int fast) {
		this.fast = fast;
	}

	/**
	 * @return the departure
	 */
	City getDeparture() {
		return departure;
	}

	/**
	 * @param departure the departure to set
	 */
	void setDeparture(City departure) {
		this.departure = departure;
	}

	/**
	 * @return the arrival
	 */
	City getArrival() {
		return arrival;
	}

	/**
	 * @param arrival the arrival to set
	 */
	void setArrival(City arrival) {
		this.arrival = arrival;
	}
	
	@Override
	public String toString() {
		return "["+departure.getName()+" - "+arrival.getName()+"]"+fast;
	}
	

} // end of class
