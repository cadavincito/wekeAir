package model;

public class Flight {

	private double price;
	private Boolean fast;

	private City departure;
	private City arrival;

	public Flight(City departure, City arrival, Boolean fast) {
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
	boolean isFast() {
		return fast;
	}

	/**
	 * @param fast the fast to set
	 */
	void setFast(boolean fast) {
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

} // end of class
