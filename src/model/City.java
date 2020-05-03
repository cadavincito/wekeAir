package model;

public class City {

	private String name;
	private String country;
	
	public City(String name, String country) {
		this.name = name;
		this.country = country;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public int hashCode() {

		return name.hashCode();
	}
	
} //end of class
