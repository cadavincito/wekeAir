package model;

import dataStructures.AdjacencyMatrix;
import dataStructures.Graph;
import dataStructures.Vertex;

public class WekeAir {

	private Graph map;
	
	public WekeAir() {
		initialize();
	}
	
	/**
	 * Initializes the graph of cities
	 * */
	public void initialize() {
		
		map = new AdjacencyMatrix<Vertex<City>>(false);
	}
}
