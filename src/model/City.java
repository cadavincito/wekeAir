package model;

import java.io.Serializable;

public class City implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6153089557214296011L;
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
	
	@Override
	public String toString() {

		return name;
	}
	
} //end of class
