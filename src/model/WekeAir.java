package model;

import java.util.ArrayList;

import dataStructures.AdjacencyMatrix;
import dataStructures.Graph;
import dataStructures.Vertex;

public class WekeAir {

	private Graph map;
	private ArrayList<Flight> fligths;
	
	public WekeAir() {
		initialize();
	}
	
	/**
	 * Initializes the graph of cities
	 * */
	public void initialize() {
		
		map = new AdjacencyMatrix<Vertex<City>>(false);
		fligths = new ArrayList<Flight>();
	}
}
