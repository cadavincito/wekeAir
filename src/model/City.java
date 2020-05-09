package model;

public class City {

	private String name;
	
	public City(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {

		return name.hashCode();
	}
	
} //end of class
