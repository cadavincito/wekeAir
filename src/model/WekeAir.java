package model;

import java.util.Hashtable;

import dataStructures.AdjacencyMatrix;
import dataStructures.Graph;
import dataStructures.Vertex;

public class WekeAir {

	private Graph map;
	private Hashtable<String,Flight> fligths;
	
	public WekeAir() {
		initialize();
	}
	
	/**
	 * Initializes the graph of cities
	 * */
	public void initialize() {
		
		map = new AdjacencyMatrix<Vertex<City>>(false);
		
		initializeVertex();
		initializeEdges();
		
		
		fligths = new Hashtable<String,Flight>();
	}
	
	public void initializeVertex() {
		
		this.map.addVertex(new Vertex<City>(new City("Bogotá")));
		this.map.addVertex(new Vertex<City>(new City("Quito")));
		this.map.addVertex(new Vertex<City>(new City("Brasilia")));
		this.map.addVertex(new Vertex<City>(new City("La Paz")));
		this.map.addVertex(new Vertex<City>(new City("Lima")));
		this.map.addVertex(new Vertex<City>(new City("Asunción")));
		this.map.addVertex(new Vertex<City>(new City("Buenos Aires")));
		this.map.addVertex(new Vertex<City>(new City("Montevideo")));
		this.map.addVertex(new Vertex<City>(new City("Santiago de Chile")));
		this.map.addVertex(new Vertex<City>(new City("Ciudad de Guatemala")));
		this.map.addVertex(new Vertex<City>(new City("San Salvador")));
		this.map.addVertex(new Vertex<City>(new City("Tegucigalpa")));
		this.map.addVertex(new Vertex<City>(new City("Managua")));
		this.map.addVertex(new Vertex<City>(new City("San José")));
		this.map.addVertex(new Vertex<City>(new City("Ciudad de Panamá")));
		this.map.addVertex(new Vertex<City>(new City("Belmopan")));
		this.map.addVertex(new Vertex<City>(new City("Caracas")));
		this.map.addVertex(new Vertex<City>(new City("Georgetown")));
		this.map.addVertex(new Vertex<City>(new City("Paramribo")));
		this.map.addVertex(new Vertex<City>(new City("Cayena")));
		this.map.addVertex(new Vertex<City>(new City("Washington")));
		this.map.addVertex(new Vertex<City>(new City("Otawa")));
		this.map.addVertex(new Vertex<City>(new City("La Habana")));

	}
	
	public void initializeEdges() {
		
	}
	
}
