package model;

import java.util.ArrayList;
import java.util.Hashtable;

import dataStructures.AdjacencyMatrix;
import dataStructures.Graph;
import dataStructures.Vertex;

public class WekeAir {

	private Graph<City> map;
	private Hashtable<String, Flight> fligths;

	private ArrayList<Vertex<City>> cities;

	public WekeAir() {
		initialize();
	}

	/**
	 * Initializes the graph of cities
	 */
	public void initialize() {

		this.map = new AdjacencyMatrix<City>(false);
		this.cities = new ArrayList<Vertex<City>>();

		initializeVertex();
		initializeEdges();

		fligths = new Hashtable<String, Flight>();
	}

	public void initializeVertex() {

		this.cities.add(new Vertex<City>(new City("Bogotá")));
		this.cities.add(new Vertex<City>(new City("Quito")));
		this.cities.add(new Vertex<City>(new City("Caracas")));
		this.cities.add(new Vertex<City>(new City("Ciudad de Panamá")));
		this.cities.add(new Vertex<City>(new City("Lima"))); //4
		this.cities.add(new Vertex<City>(new City("La Paz")));
		this.cities.add(new Vertex<City>(new City("Brasilia")));
		this.cities.add(new Vertex<City>(new City("Asunción")));
		this.cities.add(new Vertex<City>(new City("Buenos Aires")));
		this.cities.add(new Vertex<City>(new City("Montevideo")));
		this.cities.add(new Vertex<City>(new City("Santiago"))); //10
		this.cities.add(new Vertex<City>(new City("Georgetown")));
		this.cities.add(new Vertex<City>(new City("Paramribo")));
		this.cities.add(new Vertex<City>(new City("Cayena")));
		
		this.cities.add(new Vertex<City>(new City("San José")));
		this.cities.add(new Vertex<City>(new City("Managua"))); //15
		this.cities.add(new Vertex<City>(new City("Tegucigalpa")));
		this.cities.add(new Vertex<City>(new City("San Salvador")));
		this.cities.add(new Vertex<City>(new City("Belmopan")));
		this.cities.add(new Vertex<City>(new City("Ciudad de Guatemala")));
		
		this.cities.add(new Vertex<City>(new City("Washington"))); //20
		this.cities.add(new Vertex<City>(new City("Otawa")));
		this.cities.add(new Vertex<City>(new City("La Habana")));
		
		this.cities.add(new Vertex<City>(new City("Ciudad de México")));
		
		for (int i = 0; i < cities.size(); i++) {
			
			this.map.addVertex(cities.get(i));
		}

	}

	public void initializeEdges() {
		
		//Bogotá
		this.map.addEdge(cities.get(0), cities.get(1), 300);
		this.map.addEdge(cities.get(0), cities.get(2), 250);
		this.map.addEdge(cities.get(0), cities.get(3), 200);
		this.map.addEdge(cities.get(0), cities.get(4), 900);
		
		//Quito
		this.map.addEdge(cities.get(1), cities.get(4), 300);
		this.map.addEdge(cities.get(1), cities.get(5), 250);
		this.map.addEdge(cities.get(1), cities.get(3), 550);
		
		//lima
		this.map.addEdge(cities.get(4), cities.get(5), 350);
		this.map.addEdge(cities.get(4), cities.get(6), 950);
		this.map.addEdge(cities.get(4), cities.get(3), 550);
		
		//La paz
		this.map.addEdge(cities.get(5), cities.get(7), 350);
		this.map.addEdge(cities.get(5), cities.get(6), 300);
		this.map.addEdge(cities.get(5), cities.get(10), 400);
		this.map.addEdge(cities.get(5), cities.get(8), 500);
		
		//Brasilia
		this.map.addEdge(cities.get(6), cities.get(7), 700);
		this.map.addEdge(cities.get(6), cities.get(8), 300);
		this.map.addEdge(cities.get(6), cities.get(3), 550);
		this.map.addEdge(cities.get(6), cities.get(9), 200);
		
		//Buenos aires
		this.map.addEdge(cities.get(8), cities.get(9), 50);
		
		//Santiago
		this.map.addEdge(cities.get(10), cities.get(8), 350);
		this.map.addEdge(cities.get(10), cities.get(9), 250);
		this.map.addEdge(cities.get(10), cities.get(7), 200);
		
		//Caracas
		this.map.addEdge(cities.get(2), cities.get(11), 100);
		this.map.addEdge(cities.get(2), cities.get(12), 500);
		this.map.addEdge(cities.get(2), cities.get(13), 400);
		
		//Paramaibo
		this.map.addEdge(cities.get(12), cities.get(13), 100);
		this.map.addEdge(cities.get(12), cities.get(11), 50);
		
		//Ciudad de Panamá
		this.map.addEdge(cities.get(3), cities.get(14), 200);
		this.map.addEdge(cities.get(3), cities.get(20), 4500);
		this.map.addEdge(cities.get(3), cities.get(22), 500);
		this.map.addEdge(cities.get(3), cities.get(15), 500);
		
		//San jose
		this.map.addEdge(cities.get(14), cities.get(15), 100);
		this.map.addEdge(cities.get(14), cities.get(11), 50);
		
		//Managua
		this.map.addEdge(cities.get(15), cities.get(16), 100);
		this.map.addEdge(cities.get(15), cities.get(18), 300);
		
		//San Salvador
		this.map.addEdge(cities.get(17), cities.get(23), 1000);
		this.map.addEdge(cities.get(17), cities.get(18), 50);
		this.map.addEdge(cities.get(17), cities.get(22), 200);
		this.map.addEdge(cities.get(17), cities.get(19), 100);
		
		//Ciudad de Mexico
		this.map.addEdge(cities.get(23), cities.get(20), 2000);
		this.map.addEdge(cities.get(23), cities.get(21), 4000);
		this.map.addEdge(cities.get(23), cities.get(22), 800);
		this.map.addEdge(cities.get(23), cities.get(22), 200);
		
		//Washington
		this.map.addEdge(cities.get(20), cities.get(21), 1000);
		this.map.addEdge(cities.get(20), cities.get(23), 400);
		
	}

}
